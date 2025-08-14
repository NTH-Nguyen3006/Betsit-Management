    package dao;

    import entity.Payment;

    public interface PaymentDAO extends CrudDAO<Payment, String> {
boolean existsTransactionCode(String transactionCode);
boolean existsTransactionCodeForOtherId(String paymentId, String transactionCode);
    }
