USE stella_boutique;

INSERT `user` (`password`,`fullname`,`username`,`birthday`,`address`,`phoneNumber`,`email`) VALUES
('test', 'audi', 'audi','1998-12-20','home' ,'0912312345' , 'audi@gmail.com'),
('test', 'ellen', 'ellen', '1999-01-04', 'home', '0912345678', 'ellen@gmail.com'),
('test', 'kai', 'kai', '2000-02-07', 'home', '0966477382', 'kai@gmail.com'),
('test', 'richard', 'richard', '2000-03-20', 'home', '0918537624', 'richard@gmail.com'),
('test', 'stella', 'stefalen', '1998-04-25', 'home', '0987654321', 'stella@gmail.com'),
('test', 'weibin', 'weibin', '1999-05-30', 'home', '0912837465', 'weibin@gmail.com');

INSERT `discount` (`value`,`code` ,`name` ,`startDate`,`endDate`) VALUES
(0,0,0,0,0),
(0.8,"NY001", "New Year Sale 20% OFF","2021-01-01", "2021-01-30"),
(0.5,"CT001", "Christmast Gift 50% OFF","2020-12-15", "2020-12-30");
  
INSERT `item`(`name`,`quantity`,`category`,`size`,`price`,`description`,`pictureURL`) VALUES
("Jolie Jeans Jacket In Green",10,"Jacket","F",1000,"Jacket which is ready to coloring your day by day","./img/clothes/Jacket/JolieJeansJacketInGreen.jpg"),
("Jolie Jeans Jacket In Nude",10,"Jacket","F",1000,"Jacket which is ready to coloring your day by day","./img/clothes/Jacket/JolieJeansJacketInNude.jpg"),
("Jolie Jeans Jacket In Red",10,"Jacket","F",1000,"Jacket which is ready to coloring your day by day","./img/clothes/Jacket/JolieJeansJacketInRed.jpg"),
("Jolie Jeans Jacket In Apricot",10,"Jacket","F",1000,"Jacket which is ready to coloring your day by day","./img/clothes/Jacket/JolieJeansJacketInApricot.jpg"),
("Jolie Jeans Jacket In Baby Blue",10,"Jacket","F",1000,"Jacket which is ready to coloring your day by day","./img/clothes/Jacket/JolieJeansJacketInBabyBlue.jpg"),
("Jolie Jeans Jacket In Yellow",10,"Jacket","F",1000,"Jacket which is ready to coloring your day by day","./img/clothes/Jacket/JolieJeansJacketInYellow.jpg"),
("Hettie Dress",10,"Dresses","F",790,"Breezy and fuss-free","./img/clothes/Dress/HettieDress.jpg"),
("Calla Dress",10,"Dresses","F",890,"Never bend your head.","./img/clothes/Dress/CallaDress.jpg"),
("Aria Dress",10,"Dresses","F",820,"Look the world straight in the eye","./img/clothes/Dress/AriaDress.jpg"),
("Avellyn Dress",10,"Dresses","F",850,"Everyone’s favorite ","./img/clothes/Dress/AvellynDress.jpg"),
("Vessa Dress",10,"Dresses","F",880,"You can wear the frontside back or the backside front, anything you want","./img/clothes/Dress/VessaDress.jpg"),
("Dacia Dress",10,"Dresses","F",8000,"From our freshly launched","./img/clothes/Dress/DaciaDress.jpg"),
("Adiel Top In White",10,"Tops","F",8000,"Beauty begins","./img/clothes/Tops/AdielTopInWhite.jpg"),
("Mikha Top",10,"Tops","F",8000,"All you need in this life","./img/clothes/Tops/MikhaTop.jpg"),
("Shauna Top",10,"Tops","F",8000,"Success is sure","./img/clothes/Tops/ShaunaTop.jpg"),
("Flor Top",10,"Tops","F",8000,"Pair with straight pant","./img/clothes/Tops/FlorTop.jpg"),
("Sali Top",10,"Tops","F",8000,"Puffy off shoulder sleeve","./img/clothes/Tops/SaliTop.jpg"),
("Braza Top",10,"Tops","F",8000,"Burnt orange Braza","./img/clothes/Tops/BrazaTop.jpg"),
("Printed Blue Bini Skirt",10,"Bottom","F",8000,"Still looks good to wear for go to hangout","./img/clothes/Bottom/PrintedBlueBiniSkirt.jpg"),
("Printed Beige Goza Skirt",10,"Bottom","F",8000,"Stunning, fancy, yet so comfy","./img/clothes/Bottom/PrintedBeigeGozaSkirt.jpg"),
("Pleated Oversize Cardigan In Grey",10,"Jacket","F",860,"Fit that looks good on all","./img/clothes/Jacket/PleatedOversizeCardiganInGrey.jpg"),
("Pleated Oversize Cardigan In Maroon",10,"Jacket","F",860,"In the mood for Maroon ♥️","./img/clothes/Jacket/PleatedOversizeCardiganInMaroon.jpg"),
("Pleated Oversize Cardigan In White",10,"Jacket","F",860,"Perfect for the morning coffee run","./img/clothes/Jacket/PleatedOversizeCardiganInWhite.jpg"),
("Classic Cheongsam In Pastel",10,"Dresses","F",1100,"Pretty in every Color","./img/clothes/Dress/ClassicCheongsamInPastel.jpg"),
("Qi Dress",10,"Dresses","F",1160,"New Chinese Classic C0llection","./img/clothes/Dress/QiDress.jpg"),
("Shuang Xi Dress",10,"Dresses","F",1200,"All good things fullfil your new year","./img/clothes/Dress/ShuangXiDress.jpg"),
("Huo Yan Top",10,"Tops","F",800,"Pairing with a scarf","./img/clothes/Tops/HuoYanTop.jpg"),
("Feng Fu Top",10,"Tops","F",790,"Lift your style and your mood","./img/clothes/Tops/FengFuTop.jpg"),
("Fang Fang Top",10,"Tops","F",750,"Feminine and flowy","./img/clothes/Tops/FangFangTop.jpg"),
("Hui Ling Pant",10,"Bottom","F",700,"Wise Jade","./img/clothes/Bottom/HuiLingPants.jpg"),
("Mei Rong Pant",10,"Bottom","F",720,"Simple but elegant ","./img/clothes/Bottom/MeiRongPants.jpg"),
("Jin Pant",10,"Bottom","F",750,"little ordinary","./img/clothes/Bottom/JinPants.jpg");

INSERT `like` VALUES
(1,1),
(1,3),
(2,2),
(2,1),
(2,4);

INSERT `rate` VALUES
(1,1,"good",5),
(1,2,"bad quality",1),
(1,3,"good service",4);

-- status code 0 = new order,  2 = shipout, 3 = arrived(done) default 0
INSERT `order`(`orderDate`,`status`,`orderUserID`) VALUES
("2020-12-16", 0, 1),
("2020-12-15", 3, 1);

INSERT `itemlist` VALUES
(2,1,2),
(1,1,1),
(3,1,1),
(4,2,2),
(3,2,3);




