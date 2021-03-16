

--
-- Database: `stella_boutique`
--
CREATE DATABASE IF NOT EXISTS stella_boutique;
USE stella_boutique;
-- --------------------------------------------------------
--
-- Table structure for table `user`
--
CREATE TABLE IF NOT EXISTS `user` (
  `UserID` varchar(45) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Fullname` varchar(100) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `Birthday` varchar(10) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Cellphone` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserID`),
  ADD UNIQUE KEY `UserID_UNIQUE` (`UserID`),
  ADD UNIQUE KEY `Username_UNIQUE` (`Username`);

-- --------------------------------------------------------
--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `ItemID` varchar(45) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Category` varchar(100) NOT NULL,
  `Size` varchar(5) NOT NULL,
  `Price` float NOT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `PictureURL` varchar(500) DEFAULT NULL,
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`ItemID`),
  ADD UNIQUE KEY `ItemID_UNIQUE` (`ItemID`);

-- --------------------------------------------------------
--
-- Table structure for table `discount`
--
CREATE TABLE `discount` (
  `DiscountID` varchar(45) NOT NULL,
  `Value` float NOT NULL,
  `DiscountName` varchar(100) NOT NULL,
  `StartDate` datetime NOT NULL,
  `EndDate` datetime NOT NULL,
  `Code` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Indexes for table `discount`
--
ALTER TABLE `discount`
  ADD PRIMARY KEY (`DiscountID`),
  ADD UNIQUE KEY `DiscountID_UNIQUE` (`DiscountID`);

-- --------------------------------------------------------
--
-- Table structure for table `itemlist`
--

CREATE TABLE `itemlist` (
  `ItemID` varchar(45) NOT NULL,
  `OrderID` varchar(45) NOT NULL,
  `Amount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Indexes for table `itemlist`
--
ALTER TABLE `itemlist`
  ADD PRIMARY KEY (`ItemID`,`OrderID`),
  ADD UNIQUE KEY `ItemID_UNIQUE` (`ItemID`),
  ADD UNIQUE KEY `OrderID_UNIQUE` (`OrderID`);
--
-- Constraints for table `itemlist`
--
ALTER TABLE `itemlist`
  ADD CONSTRAINT `ItemUser` FOREIGN KEY (`ItemID`) REFERENCES `user` (`UserID`),
  ADD CONSTRAINT `OrderID` FOREIGN KEY (`OrderID`) REFERENCES `order` (`OrderID`);

-- --------------------------------------------------------
--
-- Table structure for table `like`
--

CREATE TABLE `like` (
  `UserID` varchar(45) NOT NULL,
  `ItemID` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Indexes for table `like`
--
ALTER TABLE `like`
  ADD PRIMARY KEY (`ItemID`,`UserID`),
  ADD UNIQUE KEY `ItemID_UNIQUE` (`ItemID`),
  ADD UNIQUE KEY `UserID_UNIQUE` (`UserID`);
--
-- Constraints for table `like`
--
ALTER TABLE `like`
  ADD CONSTRAINT `UserID` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`);
  ADD CONSTRAINT `ItemID` FOREIGN KEY (`ItemID`) REFERENCES `item` (`ItemID`);

-- --------------------------------------------------------
--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `OrderID` varchar(45) NOT NULL,
  `OrderDate` datetime NOT NULL,
  `Status` int(11) NOT NULL,
  `DiscountID` varchar(45) DEFAULT NULL,
  `OrderUser` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`OrderID`),
  ADD UNIQUE KEY `OrderID_UNIQUE` (`OrderID`),
  ADD KEY `DiscountID_idx` (`DiscountID`),
  ADD KEY `OrderUser_idx` (`OrderUser`);
--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `DiscountID` FOREIGN KEY (`DiscountID`) REFERENCES `discount` (`DiscountID`),
  ADD CONSTRAINT `OrderUser` FOREIGN KEY (`OrderUser`) REFERENCES `user` (`UserID`);

-- --------------------------------------------------------

--
-- Table structure for table `rate`
--

CREATE TABLE `rate` (
  `UserID` varchar(45) NOT NULL,
  `ItemID` varchar(45) NOT NULL,
  `Comment` varchar(100) DEFAULT NULL,
  `Rate` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--
-- Indexes for table `rate`
--
ALTER TABLE `rate`
  ADD PRIMARY KEY (`User`,`ItemID`),
  ADD UNIQUE KEY `UserID_UNIQUE` (`UserID`),
  ADD UNIQUE KEY `ItemID_UNIQUE` (`ItemID`),
  ADD KEY `UserID_idx` (`UserID`),
  ADD KEY `ItemID_idx` (`ItemID`);
--
-- Constraints for table `rate`
--
ALTER TABLE `rate`
  ADD CONSTRAINT `ItemID` FOREIGN KEY (`ItemID`) REFERENCES `item` (`ItemID`),
  ADD CONSTRAINT `UserID` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`);
COMMIT;
