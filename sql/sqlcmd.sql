CREATE DATABASE BEDSIT;
GO
USE BEDSIT
GO
USE master;
GO

ALTER DATABASE BEDSIT SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
DROP DATABASE BEDSIT;
SELECT * FROM dbo.Assets;
SELECT * FROM dbo.Contract_Tenants;
SELECT * FROM dbo.Contracts;
SELECT * FROM dbo.Invoice;
SELECT * FROM dbo.Invoice_Details;
SELECT * FROM dbo.Payments;
SELECT * FROM dbo.Roles;
SELECT * FROM dbo.Rooms;
SELECT * FROM dbo.Services;
SELECT * FROM dbo.ServiceUsages;
SELECT * FROM dbo.Tenant_Details;
SELECT * FROM dbo.Tenants;
SELECT * FROM dbo.Users;



CREATE TABLE Rooms (
    RoomId INT IDENTITY(1,1) PRIMARY KEY,
    --RoomName NVARCHAR(100) NOT NULL,
    Area FLOAT NOT NULL, -- Diện tích m2, ví dụ: 25.50 m^2
    RentPrice DECIMAL(10, 2) NOT NULL, -- Giá thuê VNĐ
    [Status] TINYINT NOT NULL CHECK ([Status] IN (0, 1, 2)) DEFAULT 0,
    RoomType NVARCHAR(100),
    Notes NVARCHAR(MAX),
);

CREATE TABLE Assets (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    RoomId INT NOT NULL,
    AssetName NVARCHAR(255) NOT NULL,
    Quantity INT NOT NULL,
    Condition NVARCHAR(255),
    created_at DATETIME DEFAULT GETDATE(), 

    FOREIGN KEY (RoomId) REFERENCES Rooms(RoomID)
	ON DELETE CASCADE
);


CREATE TABLE Tenants (
    CitizenId VARCHAR(12) PRIMARY KEY, -- Số Căn cước công dân
    FullName NVARCHAR(100) NOT NULL,
    DateOfBirth DATE,
    PhoneNumber VARCHAR(10) NOT NULL UNIQUE,
    Email VARCHAR(255),
    VehiclePlate VARCHAR(50) -- Biển số xe
);

CREATE TABLE Tenant_Details (
    CitizenId VARCHAR(12) PRIMARY KEY,
    PerCardFrontImage VARCHAR(100), -- Lưu đường dẫn tới ảnh mặt trước
    PerCardBackImage VARCHAR(100), -- Lưu đường dẫn tới ảnh mặt sau
    ResidencyStatus INT DEFAULT 0, -- Thông tin cư trú
    Occupation NVARCHAR(100), -- Nghề nghiệp
    Hometown NVARCHAR(255), -- Quê quán

    FOREIGN KEY(CitizenId) REFERENCES Tenants(CitizenId) 
        ON DELETE CASCADE
);

CREATE TABLE Contracts (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    RoomId INT,
    Tenant VARCHAR(12) NOT NULL,
    StartDate DATETIME NOT NULL,
    EndDate DATETIME,
    DepositAmount DECIMAL(10, 2) DEFAULT 0, -- Tiền cọc
    PaymentCycleMonths INT NOT NULL DEFAULT 1,
    File_scan_url VARCHAR(20),
    Notes NVARCHAR(MAX),

    FOREIGN KEY(RoomId) REFERENCES Rooms(RoomId) ON DELETE SET NULL,
    FOREIGN KEY(Tenant) REFERENCES Tenants(CitizenId) ON DELETE CASCADE 
);



CREATE TABLE Services (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    ServiceName NVARCHAR(100) NOT NULL,
    Unit nvarchar(20) NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    [Description] NVARCHAR(100)
);

CREATE TABLE ServiceUsages (
    ServiceId INT NOT NULL,
    ContractId INT NOT NULL,
    StartDate DATETIME NOT NULL,
    EndDate DATETIME,
    
    FOREIGN KEY(ServiceId) REFERENCES [Services](Id) 
        ON DELETE CASCADE,
    FOREIGN KEY(ContractId) REFERENCES [Contracts](Id) 
        ON DELETE CASCADE,
);

CREATE TABLE Invoice (
    Id int PRIMARY KEY IDENTITY(1, 1),
    ContractId int,
    Billing_period_month int NOT NULL, -- HÓa đơn tháng 
    Billing_period_year int NOT NULL, -- hóa đơn năm
    Previous_debt decimal(10,2) DEFAULT (0), --NỢ cũ
    Discount decimal(10,2) DEFAULT (0), -- giảm trừ
    TotalAmount decimal(12,2) NOT NULL,
    [Status] BIT NOT NULL DEFAULT (0),
    Due_date date,
    Created_at Datetime DEFAULT GETDATE()

    FOREIGN KEY(ContractId) REFERENCES Contracts(Id)
        ON DELETE SET NULL
);

	CREATE TABLE Invoice_Details (
	  Id INT IDENTITY(1,1) PRIMARY KEY,
	  InvoiceId int NOT NULL,
	  ServiceId int NOT NULL,
	  Quantity INT NOT NULL,
	  UnitPrice decimal(10,2) NOT NULL,
	  Subtotal decimal(12,2) NOT NULL,
	  FOREIGN KEY(InvoiceId) REFERENCES Invoice(Id) ON DELETE CASCADE,
	  FOREIGN KEY(ServiceId) REFERENCES Services(Id) 
	);

CREATE TABLE Payments ( -- ĐƠn thanh toán
    Id INT PRIMARY KEY IDENTITY(1, 1),
    InvoiceId INT NOT NULL,
    Tenant VARCHAR(12) NOT NULL,
    Amount DECIMAL(12,2) NOT NULL, -- tự lấy từ Invoice.TotalAmount
    PaymentDate DATETIME NOT NULL DEFAULT GETDATE(), -- mặc định là ngày tạo
    PaymentMethod NVARCHAR(50) NOT NULL, -- yêu cầu nhập
    TransactionCode VARCHAR(100), -- yêu cầu đúng định dạng
    Note TEXT,

    FOREIGN KEY(InvoiceId) REFERENCES Invoice(Id) ON DELETE CASCADE,
    FOREIGN KEY(Tenant) REFERENCES Tenants(CitizenId) ON DELETE CASCADE
);

CREATE TABLE Roles (
  Id int PRIMARY KEY IDENTITY(1, 1),
  RoleName varchar(50) UNIQUE NOT NULL,
  [Description] NVARCHAR(100)
);
CREATE TABLE Users (
  Username varchar(50) PRIMARY KEY,
  [Password] varchar(100) NOT NULL,
  Fullname nvarchar(100),
  Email varchar(255) UNIQUE NOT NULL,
  PhoneNumber varchar(10),
  RoleId int,
  [Status] BIT NOT NULL DEFAULT 1,
  Created_at DATETIME DEFAULT GETDATE()

  FOREIGN KEY (RoleId) REFERENCES Roles(Id) ON DELETE SET NULL
);

CREATE TABLE Contract_Tenants (
    ContractId INT NOT NULL,
    CitizenId VARCHAR(12) NOT NULL,
    Role TINYINT NOT NULL,  -- 0 = chủ hợp đồng, 1 = đồng thuê

    PRIMARY KEY (ContractId, CitizenId),
    FOREIGN KEY (ContractId) REFERENCES Contracts(Id) ON DELETE CASCADE,
    FOREIGN KEY (CitizenId) REFERENCES Tenants(CitizenId) ON DELETE NO ACTION
);

-- Dữ liệu cho bảng Rooms 
INSERT INTO Rooms (Area, RentPrice, Status, RoomType, Notes) VALUES
(25.0, 3500000.00, 0, N'Phòng Đơn', N'Phòng có ban công hướng Đông, thoáng mát'),
(30.0, 4200000.00, 1, N'Phòng Đôi', N'Đang có người thuê, hợp đồng đến 12/2025'),
(20.0, 2800000.00, 0, N'Phòng Đơn', N'Phòng nhỏ gọn, yên tĩnh, gần bếp chung'),
(35.0, 5000000.00, 2, N'Phòng Gia Đình', N'Đang sửa chữa nhỏ, dự kiến trống 08/2025'),
(28.0, 3800000.00, 0, N'Phòng Đôi', N'Phòng rộng rãi, có cửa sổ lớn'),
(22.0, 3000000.00, 1, N'Phòng Đơn', N'Đang có người thuê, hợp đồng đến 09/2025'),
(26.0, 3600000.00, 0, N'Phòng Đơn', N'Phòng view thành phố, có ánh sáng tự nhiên'),
(32.0, 4500000.00, 1, N'Phòng Đôi', N'Đang có người thuê, hợp đồng đến 01/2026'),
(18.0, 2500000.00, 0, N'Phòng Mini', N'Phòng tiện lợi cho người đi làm một mình'),
(40.0, 6000000.00, 0, N'Phòng Deluxe', N'Phòng cao cấp, đầy đủ tiện nghi, view đẹp'),
(27.0, 3700000.00, 1, N'Phòng Đôi', N'Đang có người thuê, hợp đồng đến 11/2025'),
(23.0, 3100000.00, 0, N'Phòng Đơn', N'Gần khu vực giặt là chung'),
(29.0, 3900000.00, 0, N'Phòng Đôi', N'Yên tĩnh, ít người qua lại'),
(24.0, 3300000.00, 1, N'Phòng Đơn', N'Đang có người thuê, hợp đồng đến 07/2025'),
(31.0, 4300000.00, 0, N'Phòng Đôi', N'Có thể ở ghép 2-3 người'),
(19.0, 2700000.00, 2, N'Phòng Mini', N'Đang sơn sửa, sẽ trống vào cuối tháng 7'),
(33.0, 4600000.00, 0, N'Phòng Gia Đình', N'Phòng lớn, phù hợp cho gia đình nhỏ'),
(21.0, 2900000.00, 1, N'Phòng Đơn', N'Đang có người thuê, hợp đồng đến 10/2025'),
(26.5, 3650000.00, 0, N'Phòng Đơn', N'Phòng hướng sáng, thoáng đãng'),
(34.0, 4800000.00, 0, N'Phòng Đôi', N'Gần lối thoát hiểm'),
(20.5, 2950000.00, 1, N'Phòng Đơn', N'Đang có người thuê, hợp đồng đến 08/2025'),
(28.5, 3850000.00, 0, N'Phòng Đôi', N'Có view sân thượng'),
(22.5, 3050000.00, 0, N'Phòng Đơn', N'Phòng có nội thất cơ bản'),
(30.5, 4250000.00, 1, N'Phòng Đôi', N'Đang có người thuê, hợp đồng đến 02/2026'),
(19.5, 2600000.00, 0, N'Phòng Mini', N'Giá phải chăng, phù hợp sinh viên'),
(36.0, 5200000.00, 0, N'Phòng Gia Đình', N'Có không gian riêng biệt cho trẻ em'),
(27.5, 3750000.00, 1, N'Phòng Đôi', N'Đang có người thuê, hợp đồng đến 12/2025'),
(23.5, 3150000.00, 0, N'Phòng Đơn', N'Gần khu vực để xe'),
(29.5, 3950000.00, 0, N'Phòng Đôi', N'Có thể lắp thêm điều hòa'),
(25.5, 3550000.00, 1, N'Phòng Đơn', N'Đang có người thuê, hợp đồng đến 09/2025'),
(31.5, 4350000.00, 0, N'Phòng Đôi', N'Phòng cuối hành lang, ít tiếng ồn'),
(18.5, 2550000.00, 0, N'Phòng Mini', N'Phù hợp cho người đi công tác ngắn hạn'),
(37.0, 5500000.00, 1, N'Phòng Gia Đình', N'Đang có người thuê, hợp đồng đến 03/2026'),
(24.0, 3400000.00, 0, N'Phòng Đơn', N'Phòng có đầy đủ ánh sáng tự nhiên'),
(29.0, 4000000.00, 0, N'Phòng Đôi', N'Có sẵn tủ quần áo lớn'),
(21.0, 3000000.00, 1, N'Phòng Đơn', N'Đang có người thuê, hợp đồng đến 10/2025'),
(32.0, 4400000.00, 0, N'Phòng Đôi', N'Có thể cải tạo thành 2 phòng nhỏ'),
(26.0, 3600000.00, 0, N'Phòng Đơn', N'Phòng có điều hòa sẵn'),
(38.0, 5800000.00, 0, N'Phòng Gia Đình', N'Phòng rộng, thích hợp cho 3-4 người'),
(20.0, 2800000.00, 1, N'Phòng Đơn', N'Đang có người thuê, hợp đồng đến 07/2025');

-- Dữ liệu cho bảng Tenants 
INSERT INTO Tenants (CitizenId, FullName, DateOfBirth, PhoneNumber, Email, VehiclePlate) VALUES
('001123456789', N'Nguyễn Hoàng Anh', '1990-01-15', '0901234567', 'hoanganh.nguyen@gmail.com', '51A-123.45'),
('001234567890', N'Trần Thị Mai', '1992-03-22', '0902345678', 'maithu.tran@gmail.com', '59F1-678.90'),
('001345678901', N'Lê Minh Khôi', '1988-07-01', '0903456789', 'minhkhoi.le@gmail.com', '60G1-012.34'),
('001456789012', N'Phạm Thị Thanh Thảo', '1995-11-10', '0904567890', 'thanhthao.pham@gmail.com', '54H1-567.89'),
('001567890123', N'Huỳnh Gia Bảo', '1991-05-25', '0905678901', 'giabao.huynh@gmail.com', '50K1-901.23'),
('001678901234', N'Đặng Phương Anh', '1993-02-18', '0906789012', 'phuonganh.dang@gmail.com', '43L1-345.67'),
('001789012345', N'Hoàng Tấn Phát', '1987-09-05', '0907890123', 'tanphat.hoang@gmail.com', '75M1-789.01'),
('001890123456', N'Võ Thị Thu Hà', '1994-04-12', '0908901234', 'thuha.vo@gmail.com', '52N1-123.45'),
('001901234567', N'Ngô Thanh Tùng', '1990-08-30', '0909012345', 'thanhtung.ngo@gmail.com', '37P1-567.89'),
('001012345678', N'Bùi Thị Mỹ Linh', '1996-06-03', '0910123456', 'mylinh.bui@gmail.com', '29B1-901.23'),
('002123456789', N'Đỗ Quốc Cường', '1989-10-08', '0911234567', 'quoccuong.do@gmail.com', '40C1-345.67'),
('002234567890', N'Trương Thị Bích Ngọc', '1991-01-20', '0912345678', 'bichngoc.truong@gmail.com', '51D1-789.01'),
('002345678901', N'Phan Đình Hiếu', '1993-07-15', '0913456789', 'dinhhieu.phan@gmail.com', '80E1-123.45'),
('002456789012', N'Nguyễn Thị Thanh Ngân', '1990-02-28', '0914567890', 'thanhngan.nguyen@gmail.com', '59G1-567.89'),
('002567890123', N'Đặng Văn Khoa', '1992-09-01', '0915678901', 'vankhoa.dang@gmail.com', '60H1-901.23'),
('002678901234', N'Lý Thị Kiều Anh', '1986-04-04', '0916789012', 'kieuanh.ly@gmail.com', '54J1-345.67'),
('002789012345', N'Ngô Gia Hưng', '1995-12-19', '0917890123', 'giahung.ngo@gmail.com', '50L1-789.01'),
('002890123456', N'Trần Minh Đức', '1988-06-09', '0918901234', 'minhduc.tran@gmail.com', '43M1-123.45'),
('002901234567', N'Vũ Thị Thúy Hằng', '1994-03-07', '0919012345', 'thuyhang.vu@gmail.com', '75N1-567.89'),
('002012345678', N'Phạm Quang Hải', '1990-11-21', '0920123456', 'quanghai.pham@gmail.com', '52P1-901.23'),
('003123456789', N'Châu Thị Kim Loan', '1996-08-14', '0921234567', 'kimloan.chau@gmail.com', '37Q1-345.67'),
('003234567890', N'Dương Trọng Phúc', '1987-05-16', '0922345678', 'trongphuc.duong@gmail.com', '29R1-789.01'),
('003345678901', N'Hồ Thị Cẩm Tú', '1991-09-29', '0923456789', 'camtu.ho@gmail.com', '40S1-123.45'),
('003456789012', N'Đinh Tuấn Kiệt', '1993-03-03', '0924567890', 'tuankiet.dinh@gmail.com', '51T1-567.89'),
('003567890123', N'Cao Xuân Trường', '1990-10-26', '0925678901', 'xuantruong.cao@gmail.com', '80U1-901.23'),
('003678901234', N'Lâm Thị Ngọc Anh', '1992-01-09', '0926789012', 'ngocanh.lam@gmail.com', '59V1-345.67'),
('003789012345', N'Mai Văn An', '1986-07-23', '0927890123', 'vanan.mai@gmail.com', '60W1-789.01'),
('003890123456', N'Võ Thị Hồng Gấm', '1995-04-02', '0928901234', 'honggam.vo@gmail.com', '54X1-123.45'),
('003901234567', N'Bạch Minh Quân', '1988-12-11', '0929012345', 'minhquan.bach@gmail.com', '50Y1-567.89'),
('003012345678', N'Đào Ngọc Ánh', '1994-05-06', '0930123456', 'ngocanh.dao@gmail.com', '43Z1-901.23'),
('004123456789', N'Phạm Nhật Duy', '1990-01-18', '0931234567', 'nhatduy.pham@gmail.com', '75A2-345.67'),
('004234567890', N'Nguyễn Anh Minh', '1992-03-05', '0932345678', 'anhminh.nguyen@gmail.com', '52B2-789.01'),
('004345678901', N'Trần Duy Khoa', '1988-07-29', '0933456789', 'duykhoa.tran@gmail.com', '37C2-123.45'),
('004456789012', N'Lê Thị Thu Thủy', '1995-11-14', '0934567890', 'thuthuy.le@gmail.com', '29D2-567.89'),
('004567890123', N'Huỳnh Quốc Huy', '1991-05-01', '0935678901', 'quochuy.huynh@gmail.com', '40E2-901.23'),
('004678901234', N'Đặng Thị Kim Anh', '1993-02-20', '0936789012', 'kimanh.dang@gmail.com', '51F2-345.67'),
('004789012345', N'Hoàng Việt Anh', '1987-09-09', '0937890123', 'vietanh.hoang@gmail.com', '80G2-789.01'),
('004890123456', N'Võ Thị Ngọc Linh', '1994-04-15', '0938901234', 'ngoclinh.vo@gmail.com', '59H2-123.45'),
('004901234567', N'Ngô Gia Kiệt', '1990-08-03', '0939012345', 'giakiet.ngo@gmail.com', '60J2-567.89'),
('004012345678', N'Bùi Thanh Thảo', '1996-06-07', '0940123456', 'thanhthao.bui@gmail.com', '54K2-901.23'),
('005123456789', N'Đỗ Minh Trí', '1989-10-10', '0941234567', 'minhtri.do@gmail.com', '50L2-345.67'),
('005234567890', N'Trương Thị Mỹ Duyên', '1991-01-25', '0942345678', 'myduyen.truong@gmail.com', '43M2-789.01'),
('005345678901', N'Phan Tấn Tài', '1993-07-18', '0943456789', 'tantai.phan@gmail.com', '75N2-123.45'),
('005456789012', N'Nguyễn Đức Huy', '1990-02-12', '0944567890', 'duchuy.nguyen@gmail.com', '52P2-567.89'),
('005567890123', N'Đặng Thu Hiền', '1992-09-05', '0945678901', 'thuhien.dang@gmail.com', '37Q2-901.23'),
('005678901234', N'Lý Minh Tuấn', '1986-04-06', '0946789012', 'minhtuan.ly@gmail.com', '29R2-345.67'),
('005789012345', N'Ngô Thanh Phúc', '1995-12-22', '0947890123', 'thanhphuc.ngo@gmail.com', '40S2-789.01'),
('005890123456', N'Trần Thị Ngọc Diệp', '1988-06-11', '0948901234', 'ngocdiep.tran@gmail.com', '51T2-123.45'),
('005901234567', N'Vũ Gia Anh', '1994-03-09', '0949012345', 'giaanh.vu@gmail.com', '80U2-567.89'),
('005012345678', N'Phạm Bảo Nam', '1990-11-25', '0950123456', 'baonam.pham@gmail.com', '59V2-901.23'),
('006123456789', N'Châu Anh Khoa', '1996-08-17', '0951234567', 'anhkhoa.chau@gmail.com', '60W2-345.67'),
('006234567890', N'Dương Thị Thùy Dung', '1987-05-19', '0952345678', 'thuydung.duong@gmail.com', '54X2-789.01'),
('006345678901', N'Hồ Trọng Khôi', '1991-09-02', '0953456789', 'trongkhoi.ho@gmail.com', '50Y2-123.45'),
('006456789012', N'Đinh Bảo Anh', '1993-03-06', '0954567890', 'baoanh.dinh@gmail.com', '43Z2-567.89'),
('006567890123', N'Cao Văn Đạt', '1990-10-29', '0955678901', 'vandat.cao@gmail.com', '75A3-901.23'),
('006678901234', N'Lâm Minh Quân', '1992-01-12', '0956789012', 'minhquan.lam@gmail.com', '52B3-345.67'),
('006789012345', N'Mai Văn Cường', '1986-07-26', '0957890123', 'vancuong.mai@gmail.com', '37C3-789.01'),
('006890123456', N'Võ Thị Ngọc Mai', '1995-04-05', '0958901234', 'ngocmai.vo@gmail.com', '29D3-123.45'),
('006901234567', N'Bạch Hoàng Long', '1988-12-14', '0959012345', 'hoanglong.bach@gmail.com', '40E3-567.89'),
('006012345678', N'Đào Minh Đức', '1994-05-09', '0960123456', 'minhduc.dao@gmail.com', '51F3-901.23'),
('007123456789', N'Nguyễn Trọng Đại', '1990-01-21', '0961234567', 'trongdai.nguyen@gmail.com', '80G3-345.67'),
('007234567890', N'Trần Hà Anh', '1992-03-08', '0962345678', 'haanh.tran@gmail.com', '59H3-789.01'),
('007345678901', N'Lê Minh Quân', '1988-07-31', '0963456789', 'minhquan.le@gmail.com', '60J3-123.45'),
('007456789012', N'Phạm Bảo Trang', '1995-11-17', '0964567890', 'baotrang.pham@gmail.com', '54K3-567.89'),
('007567890123', N'Huỳnh Gia Phát', '1991-05-04', '0965678901', 'giaphat.huynh@gmail.com', '50L3-901.23'),
('007678901234', N'Đặng Thanh Bình', '1993-02-23', '0966789012', 'thanhbinh.dang@gmail.com', '43M3-345.67'),
('007789012345', N'Hoàng Anh Dũng', '1987-09-12', '0967890123', 'anhdung.hoang@gmail.com', '75N3-789.01'),
('007890123456', N'Võ Thị Ngọc Bích', '1994-04-18', '0968901234', 'ngocbich.vo@gmail.com', '52P3-123.45'),
('007901234567', N'Ngô Việt Hoàng', '1990-08-06', '0969012345', 'viethoang.ngo@gmail.com', '37Q3-567.89'),
('007012345678', N'Bùi Thanh Trúc', '1996-06-10', '0970123456', 'thanhtruc.bui@gmail.com', '29R3-901.23'),
('008123456789', N'Đỗ Hải Đăng', '1989-10-13', '0971234567', 'haidang.do@gmail.com', '40S3-345.67'),
('008234567890', N'Trương Công Minh', '1991-01-28', '0972345678', 'congminh.truong@gmail.com', '51T3-789.01'),
('008345678901', N'Phan Đình Long', '1993-07-21', '0973456789', 'dinhlong.phan@gmail.com', '80U3-123.45'),
('008456789012', N'Nguyễn Thị Hồng Hạnh', '1990-02-15', '0974567890', 'honghanh.nguyen@gmail.com', '59V3-567.89'),
('008567890123', N'Đặng Anh Quân', '1992-09-08', '0975678901', 'anhquan.dang@gmail.com', '60W3-901.23'),
('008678901234', N'Lý Hoàng An', '1986-04-09', '0976789012', 'hoangan.ly@gmail.com', '54X3-345.67'),
('008789012345', N'Ngô Thị Thúy An', '1995-12-25', '0977890123', 'thuyan.ngo@gmail.com', '50Y3-789.01'),
('008890123456', N'Trần Quốc Hùng', '1988-06-14', '0978901234', 'quochung.tran@gmail.com', '43Z3-123.45'),
('008901234567', N'Vũ Thị Kim Ngân', '1994-03-12', '0979012345', 'kimngan.vu@gmail.com', '75A4-567.89'),
('008012345678', N'Phạm Duy Khang', '1990-11-28', '0980123456', 'duykhang.pham@gmail.com', '52B4-901.23'),
('009123456789', N'Châu Thị Thanh Hà', '1996-08-20', '0981234567', 'thanhha.chau@gmail.com', '37C4-345.67'),
('009234567890', N'Dương Trọng Thắng', '1987-05-22', '0982345678', 'trongthang.duong@gmail.com', '29D4-789.01'),
('009345678901', N'Hồ Thị Kim Phượng', '1991-09-05', '0983456789', 'kimphuong.ho@gmail.com', '40E4-123.45'),
('009456789012', N'Đinh Nhật Minh', '1993-03-09', '0984567890', 'nhatminh.dinh@gmail.com', '51F4-567.89'),
('009567890123', N'Cao Thị Hồng Nga', '1990-10-31', '0985678901', 'hongnga.cao@gmail.com', '80G4-901.23'),
('009678901234', N'Lâm Bích Hằng', '1992-01-15', '0986789012', 'bichhang.lam@gmail.com', '59H4-345.67'),
('009789012345', N'Mai Xuân Tùng', '1986-07-29', '0987890123', 'xuantung.mai@gmail.com', '60J4-789.01'),
('009890123456', N'Võ Duy Phát', '1995-04-08', '0988901234', 'duyphat.vo@gmail.com', '54K4-123.45'),
('009901234567', N'Bạch Minh Huy', '1988-12-17', '0989012345', 'minhhuy.bach@gmail.com', '50L4-567.89'),
('009012345678', N'Đào Thúy Ngân', '1994-05-12', '0990123456', 'thuyngan.dao@gmail.com', '43M4-901.23'),
('010123456789', N'Nguyễn Trà Giang', '1990-01-24', '0991234567', 'tragiang.nguyen@gmail.com', '75N4-345.67'),
('010234567890', N'Trần Quang Long', '1992-03-11', '0992345678', 'quanglong.tran@gmail.com', '52P4-789.01'),
('010345678901', N'Lê Kim Ngân', '1988-08-03', '0993456789', 'kimngan.le@gmail.com', '37Q4-123.45'),
('010456789012', N'Phạm Gia Hưng', '1995-11-20', '0994567890', 'giahung.pham@gmail.com', '29R4-567.89'),
('010567890123', N'Huỳnh Đăng Khoa', '1991-05-07', '0995678901', 'dangkhoa.huynh@gmail.com', '40S4-901.23'),
('010678901234', N'Đặng Anh Quân', '1993-02-26', '0996789012', 'anhquan.dang@gmail.com', '51T4-345.67'),
('010789012345', N'Hoàng Thị Ngọc', '1987-09-15', '0997890123', 'ngoc.hoang@gmail.com', '80U4-789.01'),
('010890123456', N'Võ Minh Dũng', '1994-04-21', '0998901234', 'minhdung.vo@gmail.com', '59V4-123.45'),
('010901234567', N'Ngô Thị Thúy Hằng', '1990-08-09', '0999012345', 'thuyhang.ngo@gmail.com', '60W4-567.89'),
('010012345678', N'Bùi Văn Phúc', '1996-06-13', '0990012345', 'vanphuc.bui@gmail.com', '54X4-901.23'),
('011123456789', N'Đỗ Thị Thúy Nga', '1989-10-16', '0811234567', 'thuynga.do@gmail.com', '50Y4-345.67'),
('011234567890', N'Trương Quốc Bảo', '1991-02-01', '0812345678', 'quocbao.truong@gmail.com', '43Z4-789.01'),
('011345678901', N'Phan Thị Ngọc Thảo', '1993-07-24', '0813456789', 'ngocthao.phan@gmail.com', '75A5-123.45'),
('011456789012', N'Nguyễn Trí Tuệ', '1990-02-18', '0814567890', 'tritue.nguyen@gmail.com', '52B5-567.89'),
('011567890123', N'Đặng Thanh Tùng', '1992-09-11', '0815678901', 'thanhtung.dang@gmail.com', '37C5-901.23'),
('011678901234', N'Lý Văn Đạt', '1986-04-12', '0816789012', 'vandat.ly@gmail.com', '29D5-345.67'),
('011789012345', N'Ngô Thị Thùy Linh', '1995-12-28', '0817890123', 'thuylinh.ngo@gmail.com', '40E5-789.01'),
('011890123456', N'Trần Văn Khanh', '1988-06-17', '0818901234', 'vankhanh.tran@gmail.com', '51F5-123.45'),
('011901234567', N'Vũ Thị Bích Phượng', '1994-03-15', '0819012345', 'bichphuong.vu@gmail.com', '80G5-567.89'),
('011012345678', N'Phạm Minh Thắng', '1990-12-01', '0820123456', 'minhthang.pham@gmail.com', '59H5-901.23'),
('012123456789', N'Châu Ngọc Hà', '1996-08-23', '0821234567', 'ngoch.chau@gmail.com', '60J5-345.67'),
('012234567890', N'Dương Văn Sang', '1987-05-25', '0822345678', 'vansang.duong@gmail.com', '54K5-789.01'),
('012345678901', N'Hồ Thị Kim Ngân', '1991-09-08', '0823456789', 'kimngan.ho@gmail.com', '50L5-123.45'),
('012456789012', N'Đinh Thành Long', '1993-03-12', '0824567890', 'thanhlong.dinh@gmail.com', '43M5-567.89'),
('012567890123', N'Cao Văn Sơn', '1990-11-03', '0825678901', 'vanson.cao@gmail.com', '75N5-901.23'),
('012678901234', N'Lâm Ngọc Trâm', '1992-01-18', '0826789012', 'ngoctram.lam@gmail.com', '52P5-345.67'),
('012789012345', N'Mai Trọng Nghĩa', '1986-08-01', '0827890123', 'trongnghia.mai@gmail.com', '37Q5-789.01'),
('012890123456', N'Võ Thị Thùy Dung', '1995-04-11', '0828901234', 'thuydung.vo@gmail.com', '29R5-123.45'),
('012901234567', N'Bạch Quang Trung', '1988-12-20', '0829012345', 'quangtrung.bach@gmail.com', '40S5-567.89'),
('012012345678', N'Đào Thị Mỹ Duyên', '1994-05-15', '0830123456', 'myduyen.dao@gmail.com', '51T5-901.23'),
('013123456789', N'Nguyễn Hoàng Anh', '1990-01-27', '0831234567', 'hoanganh.nguyen2@gmail.com', '80U5-345.67'),
('013234567890', N'Trần Minh Tuấn', '1992-03-14', '0832345678', 'minhtuan.tran@gmail.com', '59V5-789.01'),
('013345678901', N'Lê Thị Thu An', '1988-08-06', '0833456789', 'thuan.le@gmail.com', '60W5-123.45'),
('013456789012', N'Phạm Việt Dũng', '1995-11-23', '0834567890', 'vietdung.pham@gmail.com', '54X5-567.89'),
('013567890123', N'Huỳnh Kim Phượng', '1991-05-10', '0835678901', 'kimphuong.huynh@gmail.com', '50Y5-901.23'),
('013678901234', N'Đặng Văn Long', '1993-02-28', '0836789012', 'vanlong.dang@gmail.com', '43Z5-345.67'), -- Đã sửa ngày 29/02/1993 thành 28/02/1993
('013789012345', N'Hoàng Thị Hải Anh', '1987-09-18', '0837890123', 'haianh.hoang@gmail.com', '75A6-789.01'),
('013890123456', N'Võ Văn Nam', '1994-04-24', '0838901234', 'vannam.vo@gmail.com', '52B6-123.45'),
('013901234567', N'Ngô Thị Thúy Vy', '1990-08-12', '0839012345', 'thuyvy.ngo@gmail.com', '37C6-567.89'),
('013012345678', N'Bùi Quang Huy', '1996-06-16', '0840123456', 'quanghuy.bui@gmail.com', '29D6-901.23'),
('014123456789', N'Đỗ Minh Quân', '1989-10-19', '0841234567', 'minhquan.do@gmail.com', '40E6-345.67'),
('014234567890', N'Trương Ngọc Mai', '1991-02-04', '0842345678', 'ngocmai.truong@gmail.com', '51F6-789.01'),
('014345678901', N'Phan Thanh Long', '1993-07-27', '0843456789', 'thanhlong.phan@gmail.com', '80G6-123.45'),
('014456789012', N'Nguyễn Hải Quân', '1990-02-21', '0844567890', 'haiquan.nguyen@gmail.com', '59H6-567.89'),
('014567890123', N'Đặng Trần Phúc', '1992-09-14', '0845678901', 'tranphuc.dang@gmail.com', '60J6-901.23'),
('014678901234', N'Lý Thị Thanh Tâm', '1986-04-15', '0846789012', 'thanhtam.ly@gmail.com', '54K6-345.67'),
('014789012345', N'Ngô Văn Minh', '1995-12-31', '0847890123', 'vanminh.ngo@gmail.com', '50L6-789.01'),
('014890123456', N'Trần Thị Hoài Anh', '1988-06-20', '0848901234', 'hoaianh.tran@gmail.com', '43M6-123.45'),
('014901234567', N'Vũ Hoàng Nam', '1994-03-18', '0849012345', 'hoangnam.vu@gmail.com', '75N6-567.89'),
('014012345678', N'Phạm Nguyễn Duy', '1990-12-04', '0850123456', 'nguyenduy.pham@gmail.com', '52P6-901.23'),
('015123456789', N'Châu Văn Tùng', '1996-08-26', '0851234567', 'vantung.chau@gmail.com', '37Q6-345.67'),
('015234567890', N'Dương Thị Thu Thủy', '1987-05-28', '0852345678', 'thuthuy.duong@gmail.com', '29R6-789.01'),
('015345678901', N'Hồ Ngọc Anh', '1991-09-11', '0853456789', 'ngocanh.ho@gmail.com', '40S6-123.45'),
('015456789012', N'Đinh Gia Phong', '1993-03-15', '0854567890', 'giaphong.dinh@gmail.com', '51T6-567.89'),
('015567890123', N'Cao Văn Quyết', '1990-11-06', '0855678901', 'vanquyet.cao@gmail.com', '80U6-901.23'),
('015678901234', N'Lâm Thị Thùy Anh', '1992-01-21', '0856789012', 'thuyanh.lam@gmail.com', '59V6-345.67'),
('015789012345', N'Mai Chí Anh', '1986-08-04', '0857890123', 'chianh.mai@gmail.com', '60W6-789.01'),
('015890123456', N'Võ Thị Yến Vy', '1995-04-14', '0858901234', 'yenvy.vo@gmail.com', '54X6-123.45'),
('015901234567', N'Bạch Hải Quân', '1988-12-23', '0859012345', 'haiquan.bach@gmail.com', '50Y6-567.89'),
('015012345678', N'Đào Gia Huy', '1994-05-18', '0860123456', 'giahuy.dao@gmail.com', '43Z6-901.23'),
('016123456789', N'Nguyễn An Tuấn', '1990-01-30', '0861234567', 'antuan.nguyen@gmail.com', '75A7-345.67'),
('016234567890', N'Trần Ngọc Thảo', '1992-03-17', '0862345678', 'ngocthao.tran@gmail.com', '52B7-789.01'),
('016345678901', N'Lê Minh Khang', '1988-08-09', '0863456789', 'minhkhang.le@gmail.com', '37C7-123.45'),
('016456789012', N'Phạm Thu Ngân', '1995-11-26', '0864567890', 'thungan.pham@gmail.com', '29D7-567.89'),
('016567890123', N'Huỳnh Kim Chi', '1991-05-13', '0865678901', 'kimchi.huynh@gmail.com', '40E7-901.23'),
('016678901234', N'Đặng Thanh Hòa', '1993-03-03', '0866789012', 'thanhhoa.dang@gmail.com', '51F7-345.67'),
('016789012345', N'Hoàng Thị Ngọc Ánh', '1987-09-21', '0867890123', 'ngocanh.hoang@gmail.com', '80G7-789.01'),
('016890123456', N'Võ Duy Minh', '1994-04-27', '0868901234', 'duyminh.vo@gmail.com', '59H7-123.45'),
('016901234567', N'Ngô Thị Thùy Trang', '1990-08-15', '0869012345', 'thuytrang.ngo@gmail.com', '60J7-567.89'),
('016012345678', N'Bùi Văn Khôi', '1996-06-19', '0870123456', 'vankhoi.bui@gmail.com', '54K7-901.23'),
('017123456789', N'Đỗ Minh Long', '1989-10-22', '0871234567', 'minhlong.do@gmail.com', '50L7-345.67'),
('017234567890', N'Trương Công Phát', '1991-02-07', '0872345678', 'congphat.truong@gmail.com', '43M7-789.01'),
('017345678901', N'Phan Thị Kim Ngân', '1993-07-30', '0873456789', 'kimngan.phan@gmail.com', '75N7-123.45'),
('017456789012', N'Nguyễn Huy Tùng', '1990-02-24', '0874567890', 'huytung.nguyen@gmail.com', '52P7-567.89'),
('017567890123', N'Đặng Thị Thu Hương', '1992-09-17', '0875678901', 'thuhuong.dang@gmail.com', '37Q7-901.23'),
('017678901234', N'Lý Xuân Trường', '1986-04-18', '0876789012', 'xuantruong.ly@gmail.com', '29R7-345.67'),
('017789012345', N'Ngô Gia Khanh', '1996-01-03', '0877890123', 'giakhanh.ngo@gmail.com', '40S7-789.01'),
('017890123456', N'Trần Thị Minh Trang', '1988-06-23', '0878901234', 'minhtrang.tran@gmail.com', '51T7-123.45'),
('017901234567', N'Vũ Quốc Việt', '1994-03-21', '0879012345', 'quocviet.vu@gmail.com', '80U7-567.89'),
('017012345678', N'Phạm Thị Thanh Mai', '1990-12-07', '0880123456', 'thanhmai.pham@gmail.com', '59V7-901.23'),
('018123456789', N'Châu Bảo Anh', '1996-08-29', '0881234567', 'baoanh.chau@gmail.com', '60W7-345.67'),
('018234567890', N'Dương Trí Long', '1987-05-31', '0882345678', 'trilong.duong@gmail.com', '54X7-789.01'),
('018345678901', N'Hồ Thị Minh Tâm', '1991-09-14', '0883456789', 'minhtam.ho@gmail.com', '50Y7-123.45'),
('018456789012', N'Đinh Ngọc Anh', '1993-03-18', '0884567890', 'ngocanh.dinh@gmail.com', '43Z7-567.89'),
('018567890123', N'Cao Văn Hiếu', '1990-11-09', '0885678901', 'vanhieu.cao@gmail.com', '75A8-901.23'),
('018678901234', N'Lâm Thị Ngọc Trâm', '1992-01-24', '0886789012', 'ngoctram.lam2@gmail.com', '52B8-345.67'),
('018789012345', N'Mai Gia Phát', '1986-08-07', '0887890123', 'giaphat.mai@gmail.com', '37C8-789.01'),
('018890123456', N'Võ Hoàng Quân', '1995-04-17', '0888901234', 'hoangquan.vo@gmail.com', '29D8-123.45'),
('018901234567', N'Bạch Trọng Hiếu', '1988-12-26', '0889012345', 'tronghieu.bach@gmail.com', '40E8-567.89'),
('018012345678', N'Đào Thanh Huyền', '1994-05-21', '0890123456', 'thanhhuyen.dao@gmail.com', '51F8-901.23'),
('019123456789', N'Nguyễn Hải An', '1990-02-02', '0891234567', 'haian.nguyen@gmail.com', '80G8-345.67'),
('019234567890', N'Trần Bích Hằng', '1992-03-20', '0892345678', 'bichhang.tran@gmail.com', '59H8-789.01'),
('019345678901', N'Lê Văn Tùng', '1988-08-12', '0893456789', 'vantung.le@gmail.com', '60J8-123.45'),
('019456789012', N'Phạm Thị Yến Nhi', '1995-11-29', '0894567890', 'yennhi.pham@gmail.com', '54K8-567.89'),
('019567890123', N'Huỳnh Kim Thoa', '1991-05-16', '0895678901', 'kimthoa.huynh@gmail.com', '50L8-901.23'),
('019678901234', N'Đặng Văn Trung', '1993-03-06', '0896789012', 'vantrung.dang@gmail.com', '43M8-345.67'),
('019789012345', N'Hoàng Thị Ngọc Mai', '1987-09-24', '0897890123', 'ngocmai.hoang@gmail.com', '75N8-789.01'),
('019890123456', N'Võ Minh Long', '1994-04-30', '0898901234', 'minhlong.vo@gmail.com', '52P8-123.45'),
('019901234567', N'Ngô Thị Thu Hà', '1990-08-18', '0899012345', 'thuha.ngo@gmail.com', '37Q8-567.89'),
('019012345678', N'Bùi Thanh Trúc', '1996-06-22', '0900123456', 'thanhtruc.bui2@gmail.com', '29R8-901.23');

-- Dữ liệu cho bảng Roles (ít nhất 30 vai trò)
INSERT INTO Roles (RoleName, Description) VALUES
(N'Admin', N'Người quản trị hệ thống toàn diện'),
(N'Manager', N'Quản lý chung các hoạt động kinh doanh'),
(N'Staff', N'Nhân viên điều hành hàng ngày'),
(N'Maintenance', N'Nhân viên bảo trì cơ sở vật chất'),
(N'Security', N'Nhân viên bảo vệ'),
(N'Cleaner', N'Nhân viên vệ sinh');

-- Dữ liệu cho bảng Services 
INSERT INTO Services (ServiceName, Unit, Price, Description) VALUES
(N'Tiền Điện', N'kWh', 3500.00, N'Giá điện tính theo kWh sử dụng hàng tháng'),
(N'Tiền Nước', N'm3', 18000.00, N'Giá nước tính theo m3 sử dụng hàng tháng'),
(N'Tiền Internet', N'tháng', 150000.00, N'Phí sử dụng internet hàng tháng'),
(N'Phí Gửi Xe Máy', N'xe/tháng', 100000.00, N'Phí gửi xe máy hàng tháng'),
(N'Phí Gửi Xe Ô Tô', N'xe/tháng', 800000.00, N'Phí gửi xe ô tô hàng tháng'),
(N'Phí Vệ Sinh', N'tháng', 50000.00, N'Phí vệ sinh khu vực chung hàng tháng'),
(N'Phí Quản Lý', N'tháng', 120000.00, N'Phí quản lý tòa nhà và các tiện ích'),
(N'Dịch Vụ Giặt Là', N'lượt', 30000.00, N'Chi phí cho một lần sử dụng máy giặt/sấy'),
(N'Dịch Vụ Dọn Phòng', N'lần', 100000.00, N'Chi phí dọn dẹp phòng theo yêu cầu'),
(N'Sửa Chữa Điện', N'lần', 50000.00, N'Phí sửa chữa các lỗi điện nhỏ trong phòng'),
(N'Sửa Chữa Nước', N'lần', 50000.00, N'Phí sửa chữa các lỗi nước nhỏ trong phòng'),
(N'Thay Bóng Đèn', N'cái', 20000.00, N'Chi phí thay bóng đèn hỏng'),
(N'Thuê Tủ Lạnh', N'tháng', 150000.00, N'Phí thuê tủ lạnh cá nhân'),
(N'Thuê Máy Lạnh', N'tháng', 200000.00, N'Phí thuê máy lạnh cá nhân'),
(N'Phí Bảo Trì Thiết Bị', N'tháng', 80000.00, N'Phí bảo trì các thiết bị cố định trong phòng'),
(N'Dịch Vụ Phát Thư/Bưu Phẩm', N'lần', 10000.00, N'Chi phí hỗ trợ nhận và phát thư/bưu phẩm'),
(N'Phí Bảo Hiểm Tài Sản', N'tháng', 70000.00, N'Phí bảo hiểm cho tài sản cá nhân trong phòng'),
(N'Thuê Bếp Điện', N'tháng', 80000.00, N'Phí thuê bếp điện di động'),
(N'Thuê Bình Nóng Lạnh', N'tháng', 50000.00, N'Phí thuê bình nóng lạnh'),
(N'Dịch Vụ Tư Vấn Pháp Lý', N'lần', 500000.00, N'Tư vấn các vấn đề pháp lý liên quan đến hợp đồng'),
(N'Phí Đổ Rác Sinh Hoạt', N'tháng', 20000.00, N'Phí thu gom và xử lý rác sinh hoạt'),
(N'Phí An Ninh 24/7', N'tháng', 90000.00, N'Dịch vụ bảo vệ và giám sát an ninh liên tục'),
(N'Dịch Vụ Y Tế Cơ Bản', N'lần', 0.00, N'Hỗ trợ sơ cứu ban đầu hoặc gọi cấp cứu (miễn phí)'),
(N'Sử Dụng Phòng Gym Chung', N'tháng', 150000.00, N'Phí sử dụng phòng tập gym chung của tòa nhà'),
(N'Sử Dụng Hồ Bơi', N'tháng', 200000.00, N'Phí sử dụng hồ bơi của tòa nhà'),
(N'Dịch Vụ Chuyển Phát Nhanh', N'lần', 35000.00, N'Hỗ trợ gửi/nhận bưu phẩm nhanh chóng'),
(N'Cung Cấp Nước Uống Đóng Bình', N'bình', 25000.00, N'Cung cấp bình nước uống tinh khiết'),
(N'Phí Làm Thêm Chìa Khóa', N'cái', 50000.00, N'Chi phí làm thêm/mất chìa khóa phòng'),
(N'Vệ Sinh Điều Hòa', N'lần', 250000.00, N'Dịch vụ vệ sinh định kỳ máy lạnh'),
(N'Dịch Vụ Giặt Rèm Cửa', N'bộ', 150000.00, N'Vệ sinh rèm cửa theo yêu cầu'),
(N'Phí Sử Dụng Khu Vực BBQ', N'lần', 100000.00, N'Phí thuê và sử dụng khu vực BBQ chung'),
(N'Đổi Gas (Bếp Gas)', N'bình', 350000.00, N'Chi phí đổi bình gas (nếu phòng dùng bếp gas)'),
(N'Dịch Vụ Gọi Taxi Hộ', N'lần', 5000.00, N'Hỗ trợ gọi taxi cho khách hàng'),
(N'Vệ Sinh Sân Thượng', N'tháng', 40000.00, N'Phí vệ sinh khu vực sân thượng chung'),
(N'Phí Truyền Hình Cáp', N'tháng', 80000.00, N'Phí sử dụng dịch vụ truyền hình cáp');

-- Dữ liệu cho bảng ServiceUsages
INSERT INTO ServiceUsages (ServiceId, ContractId, StartDate, EndDate) VALUES
(1, 1, '2025-01-05 08:00:00', '2025-01-31 18:00:00'),
(2, 1, '2025-01-10 09:15:00', '2025-01-25 17:00:00'),
(3, 2, '2025-02-01 07:45:00', NULL),
(4, 2, '2025-02-15 14:00:00', '2025-02-20 19:30:00'),
(5, 3, '2025-03-03 12:00:00', NULL),
(6, 3, '2025-03-12 10:30:00', '2025-03-27 18:00:00'),
(7, 4, '2025-04-05 09:00:00', NULL),
(8, 4, '2025-04-18 16:20:00', '2025-05-01 11:00:00'),
(9, 5, '2025-05-02 08:45:00', '2025-05-15 17:30:00'),
(10, 5, '2025-05-10 14:00:00', NULL),
(11, 6, '2025-06-01 07:00:00', '2025-06-30 22:00:00'),
(12, 6, '2025-06-15 13:00:00', NULL),
(13, 7, '2025-07-04 15:30:00', '2025-07-20 20:00:00'),
(14, 7, '2025-07-10 10:00:00', NULL),
(15, 8, '2025-08-01 08:00:00', '2025-08-31 18:30:00'),
(16, 8, '2025-08-05 09:20:00', NULL),
(17, 9, '2025-09-09 12:00:00', '2025-09-15 13:30:00'),
(18, 9, '2025-09-18 11:00:00', NULL),
(19, 10, '2025-10-01 14:00:00', '2025-10-20 16:45:00'),
(20, 10, '2025-10-10 10:30:00', NULL),
(21, 1, '2025-01-20 15:00:00', NULL),
(22, 2, '2025-02-22 07:30:00', '2025-03-01 18:00:00'),
(23, 3, '2025-03-28 08:30:00', '2025-04-10 09:00:00'),
(24, 4, '2025-04-30 16:00:00', NULL),
(25, 5, '2025-05-20 10:00:00', '2025-05-25 14:00:00'),
(26, 6, '2025-06-25 11:30:00', NULL),
(27, 7, '2025-07-22 09:45:00', '2025-07-29 17:00:00'),
(28, 8, '2025-08-28 08:00:00', NULL),
(29, 9, '2025-09-05 14:30:00', NULL),
(30, 10, '2025-10-25 15:45:00', NULL);

-- Dữ liệu cho bảng Users
INSERT INTO Users (Username, Password, Fullname, Email, PhoneNumber, RoleId, Status, Created_at) VALUES
('admin01', '123456', N'Nguyễn Tấn Hoàng Nguyên', 'nguyenth@gmail.com', '0912345601', 1, 1, GETDATE()),
('manager01', '123456', N'Phạm Thùy Trinh', 'Trinhpt@gmail.com', '0912345602', 2, 1, GETDATE()),
('staff01', '123456', N'Như Lê Hoàng Minh', 'Minhnlh@gmail.com', '0912345603', 3, 1, GETDATE()),
('staff02', '123456', N'Nguyễn Đài Vĩnh Khánh', 'Khanhndv@gmail.com', '0912345605', 3, 1, GETDATE()),
('maintenance01', '123456', N'Hoàng Văn Đạt', 'hoangvandat@gmail.com', '0912345606', 4, 1, GETDATE()),
('maintenance02', '123456', N'Hồ Tấn Đạt', 'hotandat@gmail.com', '0912345617', 4, 1, GETDATE()),
('maintenance03', '123456', N'Lê Minh Khôi', 'leminhkhoi@gmail.com', '0912345627', 4, 1, GETDATE()),
('security01', '123456', N'Phan Đình Kiên', 'phandinhkien@gmail.com', '0912345609', 5, 1, GETDATE()),
('security02', '123456', N'Cao Văn Lộc', 'caovanloc@gmail.com', '0912345619', 5, 0, GETDATE()),
('security03', '123456', N'Huỳnh Trọng Hải', 'huynhtronghai@gmail.com', '0912345629', 5, 1, GETDATE()),
('cleaner01', '123456', N'Đỗ Thị Mai', 'dothimai@gmail.com', '0912345610', 6, 1, GETDATE()),
('cleaner02', '123456', N'Lâm Thị Huyền', 'lamthihuyen@gmail.com', '0912345620', 6, 1, GETDATE()),
('cleaner03', '123456', N'Đặng Thị Kim', 'dangthikim@gmail.com', '0912345630', 6, 1, GETDATE());

-- Dữ liệu cho bảng Tenant_Details 
INSERT INTO Tenant_Details (CitizenId, PerCardFrontImage, PerCardBackImage, ResidencyStatus, Occupation, Hometown) VALUES
('001123456789', NULL, NULL, 1, N'Kỹ sư phần mềm', N'Hà Nội'),
('001234567890', NULL, NULL, 0, N'Giáo viên', N'Đà Nẵng'),
('001345678901', NULL, NULL, 1, N'Freelancer', N'TP. Hồ Chí Minh'),
('001456789012', NULL, NULL, 0, N'Sinh viên', N'Huế'),
('001567890123', NULL, NULL, 1, N'Nhân viên văn phòng', N'Hải Phòng'),
('001678901234', NULL, NULL, 0, N'Bác sĩ', N'Cần Thơ'),
('001789012345', NULL, NULL, 1, N'Lập trình viên', N'Nha Trang'),
('001890123456', NULL, NULL, 0, N'Kinh doanh tự do', N'Vũng Tàu'),
('001901234567', NULL, NULL, 1, N'Họa sĩ', N'Đà Lạt'),
('001012345678', NULL, NULL, 2, N'Thợ điện', N'Biên Hòa'),
('002123456789', NULL, NULL, 2, N'Nhân viên bán hàng', N'Thanh Hóa'),
('002234567890', NULL, NULL, 0, N'Kế toán', N'Nghệ An'),
('002345678901', NULL, NULL, 1, N'Marketing', N'Quảng Ninh'),
('002456789012', NULL, NULL, 0, N'Chuyên gia tài chính', N'Bình Dương'),
('002567890123', NULL, NULL, 1, N'Nhà thiết kế', N'Đồng Nai'),
('002678901234', NULL, NULL, 0, N'Dược sĩ', N'An Giang'),
('002789012345', NULL, NULL, 1, N'Kỹ thuật viên', 'Kiên Giang'),
('002890123456', NULL, NULL, 0, N'Nhân viên ngân hàng', N'Long An'),
('002901234567', NULL, NULL, 2, N'Vận động viên', N'Bà Rịa - Vũng Tàu'),
('002012345678', NULL, NULL, 0, N'Nghệ sĩ', N'Kon Tum'),
('003123456789', NULL, NULL, 2, N'Quản lý dự án', N'Gia Lai'),
('003234567890', NULL, NULL, 0, N'Y tá', N'Đăk Lăk'),
('003345678901', NULL, NULL, 1, N'Luật sư', N'Khánh Hòa'),
('003456789012', NULL, NULL, 0, N'Nhà báo', N'Bình Thuận'),
('003567890123', NULL, NULL, 1, N'Cảnh sát', N'Quảng Nam'),
('003678901234', NULL, NULL, 0, N'Bộ đội', N'Quảng Ngãi'),
('003789012345', NULL, NULL, 1, N'Phóng viên', N'Bình Định'),
('003890123456', NULL, NULL, 0, N'Công nhân', N'Phú Yên'),
('003901234567', NULL, NULL, 1, N'Chủ doanh nghiệp', N'Gia Lai'),
('003012345678', NULL, NULL, 0, N'Nội trợ', N'Đắk Nông'),
('004123456789', NULL, NULL, 1, N'Kỹ sư phần mềm', N'Hà Nội'),
('004234567890', NULL, NULL, 2, N'Giáo viên', N'Đà Nẵng'),
('004345678901', NULL, NULL, 1, N'Freelancer', N'TP. Hồ Chí Minh'),
('004456789012', NULL, NULL, 0, N'Sinh viên', N'Huế'),
('004567890123', NULL, NULL, 1, N'Nhân viên văn phòng', N'Hải Phòng'),
('004678901234', NULL, NULL, 0, N'Bác sĩ', N'Cần Thơ'),
('004789012345', NULL, NULL, 1, N'Lập trình viên', N'Nha Trang'),
('004890123456', NULL, NULL, 0, N'Kinh doanh tự do', N'Vũng Tàu'),
('004901234567', NULL, NULL, 1, N'Họa sĩ', N'Đà Lạt'),
('004012345678', NULL, NULL, 2, N'Thợ điện', N'Biên Hòa'),
('005123456789', NULL, NULL, 2, N'Nhân viên bán hàng', N'Thanh Hóa'),
('005234567890', NULL, NULL, 0, N'Kế toán', N'Nghệ An'),
('005345678901', NULL, NULL, 1, N'Marketing', N'Quảng Ninh'),
('005456789012', NULL, NULL, 0, N'Chuyên gia tài chính', N'Bình Dương'),
('005567890123', NULL, NULL, 1, N'Nhà thiết kế', N'Đồng Nai'),
('005678901234', NULL, NULL, 0, N'Dược sĩ', N'An Giang'),
('005789012345', NULL, NULL, 1, N'Kỹ thuật viên', N'Kiên Giang'),
('005890123456', NULL, NULL, 0, N'Nhân viên ngân hàng', N'Long An'),
('005901234567', NULL, NULL, 3, N'Vận động viên', N'Bà Rịa - Vũng Tàu'),
('005012345678', NULL, NULL, 0, N'Nghệ sĩ', N'Kon Tum'),
('006123456789', NULL, NULL, 1, N'Quản lý dự án', N'Gia Lai'),
('006234567890', NULL, NULL, 2, N'Y tá', N'Đăk Lăk'),
('006345678901', NULL, NULL, 1, N'Luật sư', N'Khánh Hòa'),
('006456789012', NULL, NULL, 2, N'Nhà báo', N'Bình Thuận'),
('006567890123', NULL, NULL, 2, N'Cảnh sát', N'Quảng Nam'),
('006678901234', NULL, NULL, 2, N'Bộ đội', N'Quảng Ngãi'),
('006789012345', NULL, NULL, 1, N'Phóng viên', N'Bình Định'),
('006890123456', NULL, NULL, 0, N'Công nhân', N'Phú Yên'),
('006901234567', NULL, NULL, 1, N'Chủ doanh nghiệp', N'Gia Lai'),
('006012345678', NULL, NULL, 0, N'Nội trợ', N'Đắk Nông'),
('007123456789', NULL, NULL, 1, N'Kỹ sư phần mềm', N'Hà Nội'),
('007234567890', NULL, NULL, 0, N'Giáo viên', N'Đà Nẵng'),
('007345678901', NULL, NULL, 1, N'Freelancer', N'TP. Hồ Chí Minh'),
('007456789012', NULL, NULL, 3, N'Sinh viên', N'Huế'),
('007567890123', NULL, NULL, 1, N'Nhân viên văn phòng', N'Hải Phòng'),
('007678901234', NULL, NULL, 0, N'Bác sĩ', N'Cần Thơ'),
('007789012345', NULL, NULL, 1, N'Lập trình viên', N'Nha Trang'),
('007890123456', NULL, NULL, 0, N'Kinh doanh tự do', N'Vũng Tàu'),
('007901234567', NULL, NULL, 1, N'Họa sĩ', N'Đà Lạt'),
('007012345678', NULL, NULL, 0, N'Thợ điện', N'Biên Hòa'),
('008123456789', NULL, NULL, 1, N'Nhân viên bán hàng', N'Thanh Hóa'),
('008234567890', NULL, NULL, 0, N'Kế toán', N'Nghệ An'),
('008345678901', NULL, NULL, 1, N'Marketing', N'Quảng Ninh'),
('008456789012', NULL, NULL, 0, N'Chuyên gia tài chính', N'Bình Dương'),
('008567890123', NULL, NULL, 1, N'Nhà thiết kế', N'Đồng Nai'),
('008678901234', NULL, NULL, 0, N'Dược sĩ', N'An Giang'),
('008789012345', NULL, NULL, 1, N'Kỹ thuật viên', N'Kiên Giang'),
('008890123456', NULL, NULL, 0, N'Nhân viên ngân hàng', N'Long An'),
('008901234567', NULL, NULL, 1, N'Vận động viên', N'Bà Rịa - Vũng Tàu'),
('008012345678', NULL, NULL, 0, N'Nghệ sĩ', N'Kon Tum'),
('009123456789', NULL, NULL, 1, N'Quản lý dự án', N'Gia Lai'),
('009234567890', NULL, NULL, 0, N'Y tá', N'Đăk Lăk'),
('009345678901', NULL, NULL, 1, N'Luật sư', N'Khánh Hòa'),
('009456789012', NULL, NULL, 0, N'Nhà báo', N'Bình Thuận'),
('009567890123', NULL, NULL, 1, N'Cảnh sát', N'Quảng Nam'),
('009678901234', NULL, NULL, 0, N'Bộ đội', N'Quảng Ngãi'),
('009789012345', NULL, NULL, 1, N'Phóng viên', N'Bình Định'),
('009890123456', NULL, NULL, 0, N'Công nhân', N'Phú Yên'),
('009901234567', NULL, NULL, 1, N'Chủ doanh nghiệp', N'Gia Lai'),
('009012345678', NULL, NULL, 0, N'Nội trợ', N'Đắk Nông'),
('010123456789', NULL, NULL, 1, N'Kỹ sư phần mềm', N'Hà Nội'),
('010234567890', NULL, NULL, 0, N'Giáo viên', N'Đà Nẵng'),
('010345678901', NULL, NULL, 1, N'Freelancer', N'TP. Hồ Chí Minh'),
('010456789012', NULL, NULL, 0, N'Sinh viên', N'Huế'),
('010567890123', NULL, NULL, 1, N'Nhân viên văn phòng', N'Hải Phòng'),
('010678901234', NULL, NULL, 0, N'Bác sĩ', N'Cần Thơ'),
('010789012345', NULL, NULL, 1, N'Lập trình viên', N'Nha Trang'),
('010890123456', NULL, NULL, 0, N'Kinh doanh tự do', N'Vũng Tàu'),
('010901234567', NULL, NULL, 1, N'Họa sĩ', N'Đà Lạt'),
('010012345678', NULL, NULL, 0, N'Thợ điện', N'Biên Hòa'),
('011123456789', NULL, NULL, 1, N'Nhân viên bán hàng', N'Thanh Hóa'),
('011234567890', NULL, NULL, 0, N'Kế toán', N'Nghệ An'),
('011345678901', NULL, NULL, 1, N'Marketing', N'Quảng Ninh'),
('011456789012', NULL, NULL, 0, N'Chuyên gia tài chính', N'Bình Dương'),
('011567890123', NULL, NULL, 1, N'Nhà thiết kế', N'Đồng Nai'),
('011678901234', NULL, NULL, 0, N'Dược sĩ', N'An Giang'),
('011789012345', NULL, NULL, 1, N'Kỹ thuật viên', N'Kiên Giang'),
('011890123456', NULL, NULL, 0, N'Nhân viên ngân hàng', N'Long An'),
('011901234567', NULL, NULL, 1, N'Vận động viên', N'Bà Rịa - Vũng Tàu'),
('011012345678', NULL, NULL, 0, N'Nghệ sĩ', N'Kon Tum'),
('012123456789', NULL, NULL, 1, N'Quản lý dự án', N'Gia Lai'),
('012234567890', NULL, NULL, 0, N'Y tá', N'Đăk Lăk'),
('012345678901', NULL, NULL, 1, N'Luật sư', N'Khánh Hòa'),
('012456789012', NULL, NULL, 0, N'Nhà báo', N'Bình Thuận'),
('012567890123', NULL, NULL, 1, N'Cảnh sát', N'Quảng Nam'),
('012678901234', NULL, NULL, 0, N'Bộ đội', N'Quảng Ngãi'),
('012789012345', NULL, NULL, 1, N'Phóng viên', N'Bình Định'),
('012890123456', NULL, NULL, 0, N'Công nhân', N'Phú Yên'),
('012901234567', NULL, NULL, 1, N'Chủ doanh nghiệp', N'Gia Lai'),
('012012345678', NULL, NULL, 1, N'Nội trợ', N'Đắk Nông'),
('013123456789', NULL, NULL, 1, N'Kỹ sư phần mềm', N'Hà Nội'),
('013234567890', NULL, NULL, 1, N'Giáo viên', N'Đà Nẵng'),
('013345678901', NULL, NULL, 1, N'Freelancer', N'TP. Hồ Chí Minh'),
('013456789012', NULL, NULL, 0, N'Sinh viên', N'Huế'),
('013567890123', NULL, NULL, 1, N'Nhân viên văn phòng', N'Hải Phòng'),
('013678901234', NULL, NULL, 0, N'Bác sĩ', N'Cần Thơ'),
('013789012345', NULL, NULL, 1, N'Lập trình viên', N'Nha Trang'),
('013890123456', NULL, NULL, 0, N'Kinh doanh tự do', N'Vũng Tàu'),
('013901234567', NULL, NULL, 1, N'Họa sĩ', N'Đà Lạt'),
('013012345678', NULL, NULL, 0, N'Thợ điện', N'Biên Hòa'),
('014123456789', NULL, NULL, 1, N'Nhân viên bán hàng', N'Thanh Hóa'),
('014234567890', NULL, NULL, 0, N'Kế toán', N'Nghệ An'),
('014345678901', NULL, NULL, 1, N'Marketing', N'Quảng Ninh'),
('014456789012', NULL, NULL, 0, N'Chuyên gia tài chính', N'Bình Dương'),
('014567890123', NULL, NULL, 1, N'Nhà thiết kế', N'Đồng Nai'),
('014678901234', NULL, NULL, 0, N'Dược sĩ', N'An Giang'),
('014789012345', NULL, NULL, 1, N'Kỹ thuật viên', N'Kiên Giang'),
('014890123456', NULL, NULL, 0, N'Nhân viên ngân hàng', N'Long An'),
('014901234567', NULL, NULL, 1, N'Vận động viên', N'Bà Rịa - Vũng Tàu'),
('014012345678', NULL, NULL, 0, N'Nghệ sĩ', N'Kon Tum'),
('015123456789', NULL, NULL, 1, N'Quản lý dự án', N'Gia Lai'),
('015234567890', NULL, NULL, 0, N'Y tá', N'Đăk Lăk'),
('015345678901', NULL, NULL, 1, N'Luật sư', N'Khánh Hòa'),
('015456789012', NULL, NULL, 0, N'Nhà báo', N'Bình Thuận'),
('015567890123', NULL, NULL, 1, N'Cảnh sát', N'Quảng Nam'),
('015678901234', NULL, NULL, 0, N'Bộ đội', N'Quảng Ngãi'),
('015789012345', NULL, NULL, 1, N'Phóng viên', N'Bình Định'),
('015890123456', NULL, NULL, 0, N'Công nhân', N'Phú Yên'),
('015901234567', NULL, NULL, 1, N'Chủ doanh nghiệp', N'Gia Lai'),
('015012345678', NULL, NULL, 0, N'Nội trợ', N'Đắk Nông'),
('016123456789', NULL, NULL, 1, N'Kỹ sư phần mềm', N'Hà Nội'),
('016234567890', NULL, NULL, 0, N'Giáo viên', N'Đà Nẵng'),
('016345678901', NULL, NULL, 1, N'Freelancer', N'TP. Hồ Chí Minh'),
('016456789012', NULL, NULL, 2, N'Sinh viên', N'Huế'),
('016567890123', NULL, NULL, 2, N'Nhân viên văn phòng', N'Hải Phòng'),
('016678901234', NULL, NULL, 0, N'Bác sĩ', N'Cần Thơ'),
('016789012345', NULL, NULL, 1, N'Lập trình viên', N'Nha Trang'),
('016890123456', NULL, NULL, 0, N'Kinh doanh tự do', N'Vũng Tàu'),
('016901234567', NULL, NULL, 1, N'Họa sĩ', N'Đà Lạt'),
('016012345678', NULL, NULL, 0, N'Thợ điện', N'Biên Hòa'),
('017123456789', NULL, NULL, 1, N'Nhân viên bán hàng', N'Thanh Hóa'),
('017234567890', NULL, NULL, 0, N'Kế toán', N'Nghệ An'),
('017345678901', NULL, NULL, 1, N'Marketing', N'Quảng Ninh'),
('017456789012', NULL, NULL, 0, N'Chuyên gia tài chính', N'Bình Dương'),
('017567890123', NULL, NULL, 1, N'Nhà thiết kế', N'Đồng Nai'),
('017678901234', NULL, NULL, 0, N'Dược sĩ', N'An Giang'),
('017789012345', NULL, NULL, 1, N'Kỹ thuật viên', N'Kiên Giang'),
('017890123456', NULL, NULL, 0, N'Nhân viên ngân hàng', N'Long An'),
('017901234567', NULL, NULL, 2, N'Vận động viên', N'Bà Rịa - Vũng Tàu'),
('017012345678', NULL, NULL, 0, N'Nghệ sĩ', N'Kon Tum'),
('018123456789', NULL, NULL, 1, N'Quản lý dự án', N'Gia Lai'),
('018234567890', NULL, NULL, 0, N'Y tá', N'Đăk Lăk'),
('018345678901', NULL, NULL, 1, N'Luật sư', N'Khánh Hòa'),
('018456789012', NULL, NULL, 0, N'Nhà báo', N'Bình Thuận'),
('018567890123', NULL, NULL, 1, N'Cảnh sát', N'Quảng Nam'),
('018678901234', NULL, NULL, 3, N'Bộ đội', N'Quảng Ngãi'),
('018789012345', NULL, NULL, 1, N'Phóng viên', N'Bình Định'),
('018890123456', NULL, NULL, 0, N'Công nhân', N'Phú Yên'),
('018901234567', NULL, NULL, 1, N'Chủ doanh nghiệp', N'Gia Lai'),
('018012345678', NULL, NULL, 0, N'Nội trợ', N'Đắk Nông'),
('019123456789', NULL, NULL, 1, N'Kỹ sư phần mềm', N'Hà Nội'),
('019234567890', NULL, NULL, 2, N'Giáo viên', N'Đà Nẵng'),
('019345678901', NULL, NULL, 1, N'Freelancer', N'TP. Hồ Chí Minh'),
('019456789012', NULL, NULL, 0, N'Sinh viên', N'Huế'),
('019567890123', NULL, NULL, 1, N'Nhân viên văn phòng', N'Hải Phòng'),
('019678901234', NULL, NULL, 3, N'Bác sĩ', N'Cần Thơ'),
('019789012345', NULL, NULL, 1, N'Lập trình viên', N'Nha Trang'),
('019890123456', NULL, NULL, 0, N'Kinh doanh tự do', N'Vũng Tàu'),
('019901234567', NULL, NULL, 2, N'Họa sĩ', N'Đà Lạt'),
('019012345678', NULL, NULL, 0, N'Thợ điện', N'Biên Hòa');

-- Dữ liệu cho bảng Contracts 
INSERT INTO Contracts (RoomId, Tenant, StartDate, EndDate, DepositAmount,PaymentCycleMonths, File_scan_url, Notes) VALUES
(1, '001123456789', '2024-01-01', '2025-12-31', 7000000.00, 6, NULL, N'Hợp đồng 2 năm, thanh toán 6 tháng/lần'),
(2, '001234567890', '2024-02-15', '2025-08-14', 8400000.00, 3, NULL, N'Hợp đồng 18 tháng, có điều khoản gia hạn'),
(3, '001345678901', '2024-03-01', '2025-02-28', 5600000.00, 1, NULL, N'Hợp đồng 1 năm, thanh toán hàng tháng'),
(4, '001456789012', '2024-04-10', '2026-04-09', 10000000.00, 6, NULL, N'Hợp đồng 2 năm, có cọc lớn'),
(5, '001567890123', '2024-05-01', '2025-04-30', 7600000.00, 3, NULL, N'Hợp đồng 1 năm'),
(6, '001678901234', '2024-06-20', '2025-06-19', 6000000.00, 1, NULL, N'Hợp đồng 1 năm, có ưu đãi 1 tháng đầu'),
(7, '001789012345', '2024-07-01', '2026-06-30', 7200000.00, 6, NULL, N'Hợp đồng 2 năm'),
(8, '001890123456', '2024-08-05', '2025-08-04', 9000000.00, 3, NULL, N'Hợp đồng 1 năm, giá ưu đãi'),
(9, '001901234567', '2024-09-01', '2025-08-31', 5000000.00, 1, NULL, N'Hợp đồng 1 năm'),
(10, '001012345678', '2024-10-10', '2026-10-09', 12000000.00, 6, NULL, N'Hợp đồng 2 năm, phòng cao cấp'),
(11, '002123456789', '2024-11-01', '2025-10-31', 7400000.00, 3, NULL, N'Hợp đồng 1 năm'),
(12, '002234567890', '2024-12-15', '2025-12-14', 6200000.00, 1, NULL, N'Hợp đồng 1 năm, có thể ở ghép'),
(13, '002345678901', '2025-01-01', '2026-12-31', 7800000.00, 6, NULL, N'Hợp đồng 2 năm'),
(14, '002456789012', '2025-02-05', '2026-02-04', 6600000.00, 3, NULL, N'Hợp đồng 1 năm'),
(15, '002567890123', '2025-03-01', '2026-02-28', 8600000.00, 1, NULL, N'Hợp đồng 1 năm, phù hợp gia đình'),
(16, '002678901234', '2025-04-10', '2027-04-09', 5400000.00, 6, NULL, N'Hợp đồng 2 năm'),
(17, '002789012345', '2025-05-01', '2026-04-30', 9200000.00, 3, NULL, N'Hợp đồng 1 năm'),
(18, '002890123456', '2025-06-20', '2026-06-19', 5800000.00, 1, NULL, N'Hợp đồng 1 năm, giá tốt'),
(19, '002901234567', '2025-07-01', '2027-06-30', 7300000.00, 6, NULL, N'Hợp đồng 2 năm'),
(20, '002012345678', '2025-08-05', '2026-08-04', 5900000.00, 3, NULL, N'Hợp đồng 1 năm'),
(21, '003123456789', '2025-09-01', '2026-08-31', 6500000.00, 1, NULL, N'Hợp đồng 1 năm, gần khu vực tiện ích'),
(22, '003234567890', '2025-10-10', '2027-10-09', 8500000.00, 6, NULL, N'Hợp đồng 2 năm, có view đẹp'),
(23, '003345678901', '2025-11-01', '2026-10-31', 6300000.00, 3, NULL, N'Hợp đồng 1 năm'),
(24, '003456789012', '2025-12-15', '2026-12-14', 7100000.00, 1, NULL, N'Hợp đồng 1 năm, phòng có ban công'),
(25, '003567890123', '2024-01-05', '2025-12-04', 7100000.00, 6, NULL, N'Hợp đồng 2 năm'),
(26, '003678901234', '2024-02-20', '2025-08-19', 6900000.00, 3, NULL, N'Hợp đồng 18 tháng'),
(27, '003789012345', '2024-03-10', '2025-03-09', 5500000.00, 1, NULL, N'Hợp đồng 1 năm'),
(28, '003890123456', '2024-04-15', '2026-04-14', 7900000.00, 6, NULL, N'Hợp đồng 2 năm, có cọc'),
(29, '003901234567', '2024-05-05', '2025-05-04', 6800000.00, 3, NULL, N'Hợp đồng 1 năm'),
(30, '003012345678', '2024-06-25', '2025-06-24', 5700000.00, 1, NULL, N'Hợp đồng 1 năm'),
(31, '004123456789', '2024-07-05', '2026-07-04', 7000000.00, 6, NULL, N'Hợp đồng 2 năm'),
(32, '004234567890', '2024-08-10', '2025-08-09', 8400000.00, 3, NULL, N'Hợp đồng 1 năm, có điều khoản gia hạn'),
(33, '004345678901', '2024-09-05', '2025-09-04', 5600000.00, 1, NULL, N'Hợp đồng 1 năm, thanh toán hàng tháng');
--DROP DATABASE BEDSIT
--Dữ liệu bảng Assets
INSERT INTO Assets (RoomId, AssetName, Quantity, Condition) VALUES
-- RoomId 1-10
(1, N'Bàn làm việc', 3, N'Mới'),
(1, N'Ghế xoay', 5, N'Tốt'),
(1, N'Máy tính', 4, N'Hoạt động tốt'),
(1, N'Tủ hồ sơ', 2, N'Mới'),
(1, N'Quạt điện', 1, N'Hoạt động'),
(2, N'Máy chiếu', 1, N'Cũ nhưng dùng tốt'),
(2, N'Bảng trắng', 1, N'Tốt'),
(2, N'Loa âm trần', 4, N'Mới'),
(2, N'Micro không dây', 2, N'Tốt'),
(2, N'Bục phát biểu', 1, N'Mới'),
(3, N'Điều hòa', 1, N'Mới lắp'),
(3, N'Bình chữa cháy', 1, N'Còn hạn'),
(3, N'Đèn LED', 5, N'Tốt'),
(3, N'Camera an ninh', 1, N'Hoạt động'),
(3, N'Cảm biến khói', 2, N'Tốt'),
(4, N'Tủ tài liệu', 3, N'Hơi xước'),
(4, N'Rèm cửa', 5, N'Mới'),
(4, N'Máy in', 1, N'Hoạt động'),
(4, N'Máy hủy giấy', 1, N'Mới'),
(4, N'Két sắt', 1, N'Tốt'),
(5, N'Bàn làm việc', 4, N'Tốt'),
(5, N'Ghế nhựa', 5, N'Tốt'),
(5, N'Điện thoại bàn', 3, N'Cũ'),
(5, N'Tủ quần áo', 1, N'Mới'),
(5, N'Gương treo tường', 1, N'Tốt'),
(6, N'Máy chiếu mini', 1, N'Mới'),
(6, N'Màn chiếu', 1, N'Tốt'),
(6, N'Hệ thống âm thanh', 1, N'Mới'),
(6, N'Bộ điều khiển từ xa', 1, N'Tốt'),
(6, N'Bảng điều khiển', 1, N'Mới'),
(7, N'Bếp điện', 1, N'Mới'),
(7, N'Tủ lạnh mini', 1, N'Tốt'),
(7, N'Lò vi sóng', 1, N'Hoạt động'),
(7, N'Ấm siêu tốc', 1, N'Mới'),
(7, N'Nồi cơm điện', 1, N'Tốt'),
(8, N'Giường đơn', 2, N'Mới'),
(8, N'Tủ quần áo', 2, N'Tốt'),
(8, N'Đèn ngủ', 2, N'Hoạt động'),
(8, N'Bàn trang điểm', 1, N'Mới'),
(8, N'Ghế đẩu', 2, N'Tốt'),
(9, N'Ghế sofa', 1, N'Mới'),
(9, N'Bàn trà', 1, N'Mới'),
(9, N'Kệ sách', 1, N'Tốt'),
(9, N'Thảm trải sàn', 1, N'Mới'),
(9, N'Tranh trang trí', 2, N'Tốt'),
(10, N'Tivi', 1, N'Mới'),
(10, N'Đầu đĩa DVD', 1, N'Tốt'),
(10, N'Bộ loa', 2, N'Mới'),
(10, N'Điều khiển Tivi', 1, N'Tốt'),
(10, N'Kệ Tivi', 1, N'Mới');

INSERT INTO Invoice (ContractId, Billing_period_month, Billing_period_year, Previous_debt, Discount, TotalAmount, [Status], Due_date, Created_at) VALUES
(1,  6, 2025, 0.00, 0.00, 3850000.00, 0, '2025-07-10', GETDATE()), -- Invoice ID sẽ là 1 (ContractId 1)
(5,  6, 2025, 0.00, 0.00, 4500000.00, 0, '2025-07-15', GETDATE()), -- Invoice ID sẽ là 2 (ContractId 5)
(10, 6, 2025, 50000.00, 0.00, 3100000.00, 0, '2025-07-20', GETDATE()), -- Invoice ID sẽ là 3 (ContractId 10)
(15, 7, 2025, 0.00, 100000.00, 5200000.00, 0, '2025-08-01', GETDATE()), -- Invoice ID sẽ là 4 (ContractId 15)
(20, 7, 2025, 0.00, 0.00, 4100000.00, 0, '2025-08-05', GETDATE()), -- Invoice ID sẽ là 5 (ContractId 20)
(25, 7, 2025, 0.00, 0.00, 3300000.00, 0, '2025-08-10', GETDATE()), -- Invoice ID sẽ là 6 (ContractId 25)
(30, 8, 2025, 0.00, 0.00, 3950000.00, 0, '2025-09-01', GETDATE()), -- Invoice ID sẽ là 7 (ContractId 30)
(2,  8, 2025, 0.00, 0.00, 4600000.00, 0, '2025-09-05', GETDATE()), -- Invoice ID sẽ là 8 (ContractId 2)
(7,  8, 2025, 0.00, 0.00, 3050000.00, 0, '2025-09-10', GETDATE()), -- Invoice ID sẽ là 9 (ContractId 7)
(12, 9, 2025, 0.00, 0.00, 5600000.00, 0, '2025-10-01', GETDATE()), -- Invoice ID sẽ là 10 (ContractId 12)
(17, 9, 2025, 0.00, 0.00, 3800000.00, 0, '2025-10-05', GETDATE()), -- Invoice ID sẽ là 11 (ContractId 17)
(22, 9, 2025, 0.00, 0.00, 4700000.00, 0, '2025-10-10', GETDATE()), -- Invoice ID sẽ là 12 (ContractId 22)
(27, 10, 2025, 0.00, 0.00, 3400000.00, 0, '2025-11-01', GETDATE()), -- Invoice ID sẽ là 13 (ContractId 27)
(32, 10, 2025, 0.00, 0.00, 4200000.00, 0, '2025-11-05', GETDATE()), -- Invoice ID sẽ là 14 (ContractId 32)
(33, 11, 2025, 0.00, 0.00, 3900000.00, 0, '2025-12-01', GETDATE()); -- Invoice ID sẽ là 15 (ContractId 33)


INSERT INTO Invoice_Details (InvoiceId, ServiceId, Quantity, UnitPrice, Subtotal) VALUES
	-- Chi tiết cho Invoice 1 (ID 1)
	(1, 1, 65, 3500.00, 227500.00), -- Tiền Điện (ID 1)
	(1, 2, 8, 18000.00, 144000.00), -- Tiền Nước (ID 2)
	(1, 3, 1, 150000.00, 150000.00), -- Tiền Internet (ID 3)

	-- Chi tiết cho Invoice 2 (ID 2)
	(2, 1, 70, 3500.00, 245000.00), -- Tiền Điện
	(2, 2, 10, 18000.00, 180000.00), -- Tiền Nước
	(2, 4, 1, 100000.00, 100000.00), -- Phí Gửi Xe Máy (ID 4)

	-- Chi tiết cho Invoice 3 (ID 3)
	(3, 1, 55, 3500.00, 192500.00), -- Tiền Điện
	(3, 2, 7, 18000.00, 126000.00), -- Tiền Nước
	(3, 6, 1, 50000.00, 50000.00), -- Phí Vệ Sinh (ID 6)

	-- Chi tiết cho Invoice 4 (ID 4)
	(4, 1, 80, 3500.00, 280000.00), -- Tiền Điện
	(4, 2, 12, 18000.00, 216000.00), -- Tiền Nước
	(4, 3, 1, 150000.00, 150000.00), -- Tiền Internet

	-- Chi tiết cho Invoice 5 (ID 5)
	(5, 1, 68, 3500.00, 238000.00), -- Tiền Điện
	(5, 4, 1, 100000.00, 100000.00), -- Phí Gửi Xe Máy

	-- Chi tiết cho Invoice 6 (ID 6)
	(6, 1, 60, 3500.00, 210000.00), -- Tiền Điện
	(6, 6, 1, 50000.00, 50000.00), -- Phí Vệ Sinh

	-- Chi tiết cho Invoice 7 (ID 7)
	(7, 1, 75, 3500.00, 262500.00), -- Tiền Điện
	(7, 2, 11, 18000.00, 198000.00), -- Tiền Nước

	-- Chi tiết cho Invoice 8 (ID 8)
	(8, 1, 85, 3500.00, 297500.00), -- Tiền Điện
	(8, 3, 1, 150000.00, 150000.00), -- Tiền Internet

	-- Chi tiết cho Invoice 9 (ID 9)
	(9, 1, 50, 3500.00, 175000.00), -- Tiền Điện
	(9, 2, 6, 18000.00, 108000.00), -- Tiền Nước

	-- Chi tiết cho Invoice 10 (ID 10)
	(10, 1, 90, 3500.00, 315000.00), -- Tiền Điện
	(10, 5, 1, 800000.00, 800000.00), -- Phí Gửi Xe Ô Tô

	-- Chi tiết cho Invoice 11 (ID 11)
	(11, 1, 68, 3500.00, 238000.00), -- Tiền Điện
	(11, 2, 10, 18000.00, 180000.00), -- Tiền Nước

	-- Chi tiết cho Invoice 12 (ID 12)
	(12, 1, 70, 3500.00, 245000.00), -- Tiền Điện
	(12, 3, 1, 150000.00, 150000.00), -- Tiền Internet

	-- Chi tiết cho Invoice 13 (ID 13)
	(13, 1, 60, 3500.00, 210000.00), -- Tiền Điện
	(13, 4, 1, 100000.00, 100000.00), -- Phí Gửi Xe Máy

	-- Chi tiết cho Invoice 14 (ID 14)
	(14, 1, 75, 3500.00, 262500.00), -- Tiền Điện
	(14, 2, 11, 18000.00, 198000.00), -- Tiền Nước

	-- Chi tiết cho Invoice 15 (ID 15)
	(15, 1, 65, 3500.00, 227500.00), -- Tiền Điện
	(15, 6, 1, 50000.00, 50000.00); -- Phí Vệ Sinh


INSERT INTO Payments (InvoiceId, Tenant, Amount, PaymentDate, PaymentMethod, TransactionCode, Note) VALUES
(1,  '001123456789', 3850000.00, '2025-07-05 09:00:00', N'Cash',          'TXN20250705001', NULL),
(2,  '001234567890', 4500000.00, '2025-07-12 14:30:00', N'Bank Transfer', 'TXN20250712002', NULL),
(3,  '001345678901', 3100000.00, '2025-07-18 11:15:00', N'Cash',          'TXN20250718003', NULL),
(4,  '001456789012', 5200000.00, '2025-07-30 16:45:00', N'Credit Card',   'TXN20250730004', NULL),
(5,  '001567890123', 4100000.00, '2025-08-02 10:20:00', N'Cash',          'TXN20250802005', NULL),
(6,  '001678901234', 3300000.00, '2025-08-08 13:50:00', N'Bank Transfer', 'TXN20250808006', NULL),
(7,  '001789012345', 3950000.00, '2025-08-30 09:40:00', N'Cash',          'TXN20250830007', NULL),
(8,  '001890123456', 4600000.00, '2025-09-03 15:25:00', N'Credit Card',   'TXN20250903008', NULL),
(9,  '001901234567', 3050000.00, '2025-09-08 11:55:00', N'Cash',          'TXN20250908009', NULL),
(10, '002012345678', 5600000.00, '2025-09-28 17:10:00', N'Bank Transfer', 'TXN20250928010', NULL),
(11, '002123456789', 3800000.00, '2025-10-03 09:30:00', N'Cash',          'TXN20251003011', NULL),
(12, '002234567890', 4700000.00, '2025-10-07 14:00:00', N'Credit Card',   'TXN20251007012', NULL),
(13, '002345678901', 3400000.00, '2025-10-29 10:45:00', N'Bank Transfer', 'TXN20251029013', NULL),
(14, '002456789012', 4200000.00, '2025-11-03 12:15:00', N'Cash',          'TXN20251103014', NULL),
(15, '002567890123', 3900000.00, '2025-11-28 16:40:00', N'Bank Transfer', 'TXN20251128015', NULL);

INSERT INTO Contract_Tenants (ContractId, CitizenId, Role) VALUES
(1, '001123456789', 0),
(2, '001234567890', 0),
(2, '003123456789', 1),
(3, '001345678901', 0),
(3, '003234567890', 1),
(4, '001456789012', 0),
(5, '001567890123', 0),
(6, '001678901234', 0),
(7, '001789012345', 0),
(7, '004345678901', 1),
(8, '001890123456', 0),
(9, '001901234567', 0),
(10, '001012345678', 0),
(11, '002123456789', 0),
(12, '002234567890', 0),
(12, '003345678901', 1),
(13, '002345678901', 0),
(14, '002456789012', 0),
(15, '002567890123', 0),
(16, '002678901234', 0),
(17, '002789012345', 0),
(18, '002890123456', 0),
(19, '002901234567', 0),
(20, '002012345678', 0),
(21, '003123456789', 0),
(22, '003234567890', 0),
(23, '003345678901', 0),
(24, '003456789012', 0),
(25, '003567890123', 0),
(26, '003678901234', 0),
(27, '003789012345', 0),
(28, '003890123456', 0),
(29, '003901234567', 0),
(30, '003012345678', 0),
(31, '004123456789', 0),
(32, '004234567890', 0),
(33, '004345678901', 0);