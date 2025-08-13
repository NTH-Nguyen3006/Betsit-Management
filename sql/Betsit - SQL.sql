CREATE DATABASE BEDSIT;
GO
USE BEDSIT
GO

-- DROP DATABASE BEDSIT

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
select * from Assets
delete Assets where Id = 1;

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
    PaymentCycleMonths TINYINT NOT NULL DEFAULT 1,
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
  InvoiceId int PRIMARY KEY,
  ServiceId int NOT NULL,
  Quantity INT NOT NULL,
  UnitPrice decimal(10,2) NOT NULL,
  Subtotal decimal(12,2) NOT NULL

  FOREIGN KEY(InvoiceId) REFERENCES Invoice(Id)
    ON DELETE CASCADE
);

CREATE TABLE Payments ( --ĐƠn thanh toán
    Id int PRIMARY KEY IDENTITY(1, 1),
    InvoiceId int NOT NULL,
    Tenant varchar(12),
    Amount decimal(12,2) NOT NULL,
    PaymentDate datetime NOT NULL,
    PaymentMethod nvarchar(50) NOT NULL,
    TransactionCode varchar(100),
    Note text

    FOREIGN KEY(InvoiceId) REFERENCES Invoice(Id)
        ON DELETE CASCADE,
    FOREIGN KEY(Tenant) REFERENCES Tenants(CitizenId)
        ON DELETE CASCADE
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
    ContractId INT PRIMARY KEY,
    PersonalId INT,
    [Role] TINYINT -- Enum
    FOREIGN KEY(ContractId) REFERENCES Contracts(Id) ON DELETE CASCADE,
);