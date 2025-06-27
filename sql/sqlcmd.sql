CREATE DATABASE BEDSIT;
GO
USE BEDSIT
GO

CREATE TABLE Rooms (
    RoomId INT IDENTITY(1,1) PRIMARY KEY,
    --RoomName NVARCHAR(100) NOT NULL,
    Area DECIMAL(5, 2) NOT NULL, -- Diện tích m2, ví dụ: 25.50 m^2
    RentPrice DECIMAL(9, 2) NOT NULL, -- Giá thuê VNĐ
    [Status] TINYINT NOT NULL CHECK ([Status] IN (0, 1, 2)) DEFAULT 0,
    Notes NVARCHAR(MAX),
);

CREATE TABLE Tenants (
    PersionalId VARCHAR(12) PRIMARY KEY, -- Số Căn cước công dân
    FullName NVARCHAR(100) NOT NULL,
    DateOfBirth DATE,
    PhoneNumber VARCHAR(10) NOT NULL UNIQUE,
    Email VARCHAR(255),
    LicensePlate VARCHAR(10) -- Biển số xe
);

CREATE TABLE Tenant_Details (
    PersionalId VARCHAR(12) PRIMARY KEY,
    PerCard_FrontImage VARCHAR(20), -- Lưu đường dẫn tới ảnh mặt trước
    PerCard_BackImage VARCHAR(20), -- Lưu đường dẫn tới ảnh mặt sau
    ResidencyStatus TINYINT CHECK (ResidencyStatus IN (0, 1, 2))
        DEFAULT 0, -- Thông tin cư trú
    Occupation NVARCHAR(100), -- Nghề nghiệp
    Hometown NVARCHAR(255), -- Quê quán

    FOREIGN KEY(PersionalId) REFERENCES Tenant(PersionalId) 
        ON DELETE CASCADE
);

CREATE TABLE Contracts (
    ContractId INT IDENTITY(1,1) PRIMARY KEY,
    RoomId INT NOT NULL,
    Tenant VARCHAR(12) NOT NULL,
    StartDate DATETIME NOT NULL,
    EndDate DATETIME,
    DepositAmount DECIMAL(9, 2) DEFAULT 0, -- Tiền cọc
    Notes NVARCHAR(MAX),

    FOREIGN KEY(RoomId) REFERENCES Room(RoomId) ON DELETE SET NULL,
    FOREIGN KEY(Tenant) REFERENCES Tenant(PersionalId) ON DELETE CASCADE
);

CREATE TABLE Contract_Tenates (
    Contract_id INT,
    Personal_id INT,
    [Role] TINYINT -- Enum
);

CREATE TABLE Service (
    ServiceId INT IDENTITY(1,1) PRIMARY KEY,
    ServiceName NVARCHAR(100) NOT NULL,
    Price DECIMAL(9, 2) NOT NULL
);

CREATE TABLE ServiceUsage (
    ServiceId INT NOT NULL,
    ContractId INT NOT NULL,
    StartDate DATETIME NOT NULL,
    EndDate DATETIME
    
    FOREIGN KEY(ServiceId) REFERENCES [Service](ServiceId) 
        ON DELETE SET NULL,
    FOREIGN KEY(ContractId) REFERENCES [Contract](ContractId) 
        ON DELETE CASCADE,
);

CREATE TABLE Invoice (
    InvoiceId INT IDENTITY(1,1) PRIMARY KEY,
    ContractId INT,
    BillingMonth DATE NOT NULL,
    TotalAmount DECIMAL(9, 2) NOT NULL,
    [Status] BIT NOT NULL DEFAULT 0,
    
    FOREIGN KEY(ContractId) REFERENCES [Contract](ContractId) 
        ON DELETE SET NULL,
);
GO