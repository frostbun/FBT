SELECT SupplierTransactionID, SupplierID, TransactionType, TransactionDate, TransactionAmount
FROM SupplierTransactions
WHERE TransactionDate BETWEEN '2013-5-20' AND '2013-5-31'
ORDER BY TransactionType, TransactionAmount DESC
