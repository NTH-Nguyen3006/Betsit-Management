package utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap; // Thêm import này
import java.util.List;
import java.util.Map; // Thêm import này

/**
 * Lớp tiện ích hỗ trợ truy vấn và chuyển đổi sang đối tượng
 *
 * @author NghiemN
 * @version 1.0
 */
public class XQuery {

    /**
     * Truy vấn 1 đối tượng
     *
     * @param <B>       kiểu của đối tượng cần chuyển đổi
     * @param beanClass lớp của đối tượng kết quả
     * @param sql       câu lệnh truy vấn
     * @param values    các giá trị cung cấp cho các tham số của SQL
     * @return kết quả truy vấn
     * @throws RuntimeException lỗi truy vấn
     */
    public static <B> B getSingleBean(Class<B> beanClass, String sql, Object... values) {
        List<B> list = XQuery.getBeanList(beanClass, sql, values);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    /**
     * Truy vấn nhiều đối tượng
     *
     * @param <B>       kiểu của đối tượng cần chuyển đổi
     * @param beanClass lớp của đối tượng kết quả
     * @param sql       câu lệnh truy vấn
     * @param values    các giá trị cung cấp cho các tham số của SQL
     * @return danh sách kết quả truy vấn
     * @throws RuntimeException lỗi truy vấn
     */
    public static <B> List<B> getBeanList(Class<B> beanClass, String sql, Object... values) {
        List<B> list = new ArrayList<>();
        try (ResultSet resultSet = XJdbc.executeQuery(sql, values)) {
            while (resultSet.next()) {
                list.add(XQuery.fillBean(resultSet, beanClass));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private static <B> B fillBean(ResultSet resultSet, Class<B> beanClass) throws SQLException {
        B bean;
        try {
            bean = beanClass.getConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // Lấy ResultSetMetaData để tìm tên cột không phân biệt chữ hoa chữ thường
        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        Map<String, Integer> columnNameToIndexMap = new HashMap<>();
        for (int i = 1; i <= columnCount; i++) {
            // Sử dụng getColumnLabel để có được tên cột được sử dụng trong truy vấn SELECT
            // (có thể có bí danh)
            // hoặc getColumnName nếu bạn muốn tên cột thực tế trong DB
            columnNameToIndexMap.put(metaData.getColumnLabel(i).toLowerCase(), i);
        }

        Method[] methods = beanClass.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                String expectedColumnName = method.getName().substring(3); // Ví dụ: "Area" từ setArea()
                String lowerCaseExpectedColumnName = expectedColumnName.toLowerCase();

                if (columnNameToIndexMap.containsKey(lowerCaseExpectedColumnName)) {
                    try {
                        int columnIndex = columnNameToIndexMap.get(lowerCaseExpectedColumnName);
                        Object value = resultSet.getObject(columnIndex);
                        method.invoke(bean, value);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                            | SQLException e) {
                        // In lỗi cụ thể hơn nếu có vấn đề khi thiết lập giá trị
                        System.out.printf("+ Lỗi khi gọi setter cho cột '%s': %s%n", expectedColumnName,
                                e.getMessage());
                    }
                } else {
                    System.out.printf("+ Cột '%s' không tìm thấy trong ResultSet!%n", expectedColumnName);
                }
            }
        }
        return bean;
    }

    public static <T> List<T> getList(Class<T> typeClass, String sql, Object... values) {
        List<T> list = new ArrayList<>();
        try {
            ResultSet resultSet = XJdbc.executeQuery(sql, values); // Sử dụng XJdbc để thực thi truy vấn
            while (resultSet.next()) {
                // Lấy giá trị từ cột đầu tiên (chỉ số 1) và ép kiểu về T
                list.add((T) resultSet.getObject(1));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    // public static void main(String[] args) {
    // demo1();
    // demo2();
    // }

    // private static void demo1() {
    // String sql = "SELECT * FROM Users WHERE Username=? AND Password=?";
    // User user = XQuery.getSingleBean(User.class, sql, "NghiemN", "123456");
    // }
    //
    // private static void demo2() {
    // String sql = "SELECT * FROM Users";
    // List<User> users = XQuery.getBeanList(User.class, sql);
    // }
}

// package utils;

// import entity.Tenant;

// import java.lang.reflect.InvocationTargetException;
// import java.lang.reflect.Method;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;
// import java.math.BigDecimal; // Đảm bảo đã import BigDecimal

// /**
// * Lớp tiện ích hỗ trợ truy vấn và chuyển đổi sang đối tượng
// *
// * @author NghiemN
// * @version 1.0
// */
// public class XQuery {

// public static <B> B getSingleBean(Class<B> beanClass, String sql, Object...
// values) {
// List<B> list = XQuery.getBeanList(beanClass, sql, values);
// if (!list.isEmpty()) {
// return list.get(0);
// }
// return null;
// }

// public static <B> List<B> getBeanList(Class<B> beanClass, String sql,
// Object... values) {
// List<B> list = new ArrayList<>();
// try (
// var resultSet = XJdbc.executeQuery(sql, values)) {
// while (resultSet.next()) {
// list.add(XQuery.getBean(beanClass, resultSet));
// }
// } catch (SQLException ex) {
// throw new RuntimeException(ex);
// }
// return list;
// }

// private static <B> B getBean(Class<B> beanClass, ResultSet resultSet) {
// B bean;
// try {
// bean = beanClass.getConstructor().newInstance();
// } catch (ReflectiveOperationException e) {
// throw new RuntimeException(e);
// }

// for (Method method : beanClass.getMethods()) {
// if (method.getName().startsWith("set")) {
// String name = method.getName();
// String expectedColumnName = name.substring(3); // Ví dụ: "setRoomId" ->
// "RoomId", "setArea" -> "Area"

// Class<?>[] parameterTypes = method.getParameterTypes();
// if (parameterTypes.length != 1) {
// continue;
// }
// Class<?> parameterType = parameterTypes[0];

// try {
// Object value = resultSet.getObject(name.substring(3));
// method.invoke(bean, value);
// } catch (IllegalAccessException | IllegalArgumentException | SQLException
// | InvocationTargetException e) {
// System.out.printf("+ Column '%s' not found!\r\n", name.substring(3));
// }
// }
// }
// return bean;
// }

// public static void main(String[] args) {
// Tenant t = new Tenant();
// }

// public static <T> List<T> getList(Class<T> typeClass, String sql, Object...
// values) {
// List<T> list = new ArrayList<>();
// try (ResultSet resultSet = XJdbc.executeQuery(sql, values)) {
// while (resultSet.next()) {
// list.add((T) resultSet.getObject(1));
// }
// } catch (SQLException ex) {
// throw new RuntimeException(ex);
// }
// return list;
// }
// }