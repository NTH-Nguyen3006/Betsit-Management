CREATE DATABASE BEDSIT;
GO
USE BEDSIT
GO

CREATE TABLE Rooms (
    RoomId INT IDENTITY(1,1) PRIMARY KEY,
    --RoomName NVARCHAR(100) NOT NULL,
    Area FLOAT NOT NULL, -- Diện tích m2, ví dụ: 25.50 m^2
    RentPrice DECIMAL(10, 2) NOT NULL, -- Giá thuê VNĐ
    [Status] TINYINT NOT NULL CHECK ([Status] IN (0, 1, 2)) DEFAULT 0,
    RoomType NVARCHAR(100),
    Notes NVARCHAR(MAX),
);

CREATE TABLE Tenants (
    Citizen_id VARCHAR(12) PRIMARY KEY, -- Số Căn cước công dân
    FullName NVARCHAR(100) NOT NULL,
    DateOfBirth DATE,
    PhoneNumber VARCHAR(10) NOT NULL UNIQUE,
    Email VARCHAR(255),
    VehiclePlate VARCHAR(10) -- Biển số xe
);

CREATE TABLE Tenant_Details (
    Citizen_id VARCHAR(12) PRIMARY KEY,
    PerCard_FrontImage VARCHAR(20), -- Lưu đường dẫn tới ảnh mặt trước
    PerCard_BackImage VARCHAR(20), -- Lưu đường dẫn tới ảnh mặt sau
    ResidencyStatus BIT DEFAULT 0, -- Thông tin cư trú
    Occupation NVARCHAR(100), -- Nghề nghiệp
    Hometown NVARCHAR(255), -- Quê quán

    FOREIGN KEY(Citizen_id) REFERENCES Tenants(Citizen_id) 
        ON DELETE CASCADE
);

CREATE TABLE Contracts (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    RoomId INT,
    Tenant VARCHAR(12) NOT NULL,
    StartDate DATETIME NOT NULL,
    EndDate DATETIME,
    DepositAmount DECIMAL(10, 2) DEFAULT 0, -- Tiền cọc
    Payment_cycle_months TINYINT NOT NULL DEFAULT 1,
    File_scan_url VARCHAR(20),
    Notes NVARCHAR(MAX),

    FOREIGN KEY(RoomId) REFERENCES Rooms(RoomId) ON DELETE SET NULL,
    FOREIGN KEY(Tenant) REFERENCES Tenants(Citizen_id) ON DELETE CASCADE
);

CREATE TABLE Contract_Tenants (
    Contract_id INT PRIMARY KEY,
    Personal_id INT,
    [Role] TINYINT -- Enum
    FOREIGN KEY(Contract_id) REFERENCES Contracts(Id) ON DELETE CASCADE,
);

CREATE TABLE Services (
    Id INT IDENTITY(1,1) PRIMARY KEY,
    ServiceName NVARCHAR(100) NOT NULL,
    Unit nvarchar(20) NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    [Description] TEXT
);

CREATE TABLE ServiceUsages (
    ServiceId INT NOT NULL,
    ContractId INT NOT NULL,
    StartDate DATETIME NOT NULL,
    EndDate DATETIME
    
    FOREIGN KEY(ServiceId) REFERENCES [Services](Id) 
        ON DELETE CASCADE,
    FOREIGN KEY(ContractId) REFERENCES [Contracts](Id) 
        ON DELETE CASCADE,
);

CREATE TABLE Invoice (
    Id int PRIMARY KEY IDENTITY(1, 1),
    Contract_id int,
    Billing_period_month int NOT NULL, -- HÓa đơn tháng 
    Billing_period_year int NOT NULL, -- hóa đơn năm
    Previous_debt decimal(10,2) DEFAULT (0), --NỢ cũ
    Discount decimal(10,2) DEFAULT (0), -- giảm trừ
    Total_amount decimal(12,2) NOT NULL,
    [Status] BIT NOT NULL DEFAULT (0),
    Due_date date,
    Created_at Datetime DEFAULT GETDATE()

    FOREIGN KEY(Contract_id) REFERENCES Contracts(Id)
        ON DELETE SET NULL
);

CREATE TABLE Invoice_Details (
  Invoice_id int PRIMARY KEY,
  Service_id int NOT NULL,
  Quantity INT NOT NULL,
  Unit_price decimal(10,2) NOT NULL,
  Subtotal decimal(12,2) NOT NULL

  FOREIGN KEY(Invoice_id) REFERENCES Invoice(Id)
    ON DELETE CASCADE
);

CREATE TABLE Payments ( --ĐƠn thanh toán
    Id int PRIMARY KEY IDENTITY(1, 1),
    Invoice_id int NOT NULL,
    Tenant varchar(12),
    Amount decimal(12,2) NOT NULL,
    Payment_date datetime NOT NULL,
    Payment_method nvarchar(50) NOT NULL,
    Transaction_code varchar(100),
    Note text

    FOREIGN KEY(Invoice_id) REFERENCES Invoice(Id)
        ON DELETE CASCADE,
    FOREIGN KEY(Tenant) REFERENCES Tenants(Citizen_id)
        ON DELETE CASCADE
);

CREATE TABLE Roles (
  Id int PRIMARY KEY IDENTITY(1, 1),
  Role_name varchar(50) UNIQUE NOT NULL,
  [Description] text
);


CREATE TABLE Users (
  Id int PRIMARY KEY IDENTITY(1, 1),
  Username varchar(50) UNIQUE NOT NULL,
  [Password] varchar(100) NOT NULL,
  Fullname nvarchar(100),
  Email varchar(255) UNIQUE NOT NULL,
  Phone_number varchar(10),
  Role_id int,
  [Status] varchar(20) NOT NULL DEFAULT 'Active',
  Created_at DATETIME DEFAULT GETDATE()

  FOREIGN KEY (Role_id) REFERENCES Roles(Id) ON DELETE SET NULL
);
GO

--DROP DATABASE BEDSIT