USE stela_boutique;

INSERT `user` VALUES
(100001, 'test', 'audi', 'audi','1998-12-20','home' ,'0912312345' , 'audi@gmail.com'),
(100002, 'test', 'ellen', 'ellen', '1999-01-04', 'home', '0912345678', 'ellen@gmail.com'),
(100003, 'test', 'kai', 'kai', '2000-02-07', 'home', '0966477382', 'kai@gmail.com'),
(100004, 'test', 'richard', 'richard', '2000-03-20', 'home', '0918537624', 'richard@gmail.com'),
(100005, 'test', 'stella', 'stefalen', '1998-04-25', 'home', '0987654321', 'stella@gmail.com'),
(100006, 'test', 'weibin', 'weibin', '1999-05-30', 'home', '0912837465', 'weibin@gmail.com');

INSERT `discount` VALUES
(300001, 0.8, "New Year Sale 20% OFF","2021-01-01", "2021-01-30"),
(300001, 0.5, "Christmast Gift 50% OFF","2020-12-15", "2020-12-30");

INSERT `item` VALUES
(200001,10,"coat","M",1000,"Notch Collar Teddy Overcoat",""),
(200002,10,"dresses","L",860,"Ditsy Floral Smock Dress",""),
(200003,10,"hoodie","XL",499,"Letter Graphic Thermal Drawstring Hoodie",""),
(200004,10,"jeans","29",698,"High Waist Cord Carrot Pants","");

INSERT `like` VALUES
(100001,200001),
(100001,200003),
(100002,200002),
(100002,200001),
(100002,200004);

INSERT `rate` VALUES
(100001,200001,"good",5),
(100002,200001,"bad quality",1),
(100003,200001,"good service",4);

-- status code 0 = new order, 1 = checkout, 2 = shipout, 3 = arrived(done) default 0
INSERT `order` VALUES
(400001,"2020-12-16", 0, null, 100001),
(400002,"2020-12-15", 3, null, 100002);

INSERT `itemlist` VALUES
(200002,400001,2),
(200001,400001,1),
(200003,400001,1),
(200004,400002,2),
(200003,400002,3);




