<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/fragment/header.jsp" />
<c:set var="funcName" value="REG" scope="session" />
  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Products</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" rel="stylesheet">  
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
    <link href="../homepage/index_main.css" rel="stylesheet">
</head>
<body>

    <!-- 商品輪播 -->
        <div id="carouselExampleControls" class="carousel slide" data-ride="carousel" style="height:400px; margin: 0px">
                <div class="carousel-inner" style="overflow:hidden; height:400px; margin:0px;">
                  <div class="carousel-item active" >
                    <img class="d-block w-100" src="../images/03.jpg" alt="First slide" style="width:100%;">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="../images/02.jpg" alt="Second slide">
                  </div>
                  <div class="carousel-item">
                    <img class="d-block w-100" src="../images/01.jpg" alt="Third slide">
                  </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
                </a>
              </div>
        <!-- -------------------------navgation end----------------------------- -->
        <div class="content container-fluid" style="display: flex; padding: 0px;">
            <!-- 側邊欄 -->
            <div class="section col-lg-2" style="width:100px; font-weight:400 ;font-size:20px;padding: 20px 0px;">
                <nav class="nav flex-column nav-tabs">
                    <a class="nav-link active"  style="font-color: rgb(57, 15, 116);font-weight:600;">分類商品</a>
                    <a class="nav-link" href="#" style="color:rgba(244, 232, 248, 0.925)" >原創桌遊</a>
                    <a class="nav-link" href="#" style="color:rgba(244, 232, 248, 0.925)">文創周邊小物</a>
                    
                </nav>
                <nav class="nav flex-column nav-tabs">
                        <a class="nav-link active" style="font-color: rgb(57, 15, 116);font-weight:600;">人氣商品推薦</a>
                        <a class="nav-link" href="#" style="color:rgba(244, 232, 248, 0.925)">每週新品</a>
                        <a class="nav-link" href="#" style="color:rgba(244, 232, 248, 0.925)">熱銷推薦</a>
                        <a class="nav-link" href="#" style="color:rgba(244, 232, 248, 0.925)">高冷系列</a>
                        <a class="nav-link" href="#" style="color:rgba(244, 232, 248, 0.925)">厭世系列</a>
                        <a class="nav-link" href="#" style="color:rgba(244, 232, 248, 0.925)">簡約系列</a>
                        <a class="nav-link" href="#" style="color:rgba(244, 232, 248, 0.925)">個性系列</a>
                        
                </nav>
                <nav class="nav flex-column nav-tabs">
                        <a class="nav-link" href="#" style="color:rgba(244, 232, 248, 0.925)"><i class="fas fa-shopping-cart fa-lg"></i></a>
                        <a class="nav-link" href="#" style="color:rgba(244, 232, 248, 0.925)">我的訂單</a>
                        
                </nav>
            </div>
            <!-- 商品列表 -->
<!--             container col-lg-10 -->
            <div class=" container col-lg-10" style=" display: flex; justify-content: space-between; flex-wrap: wrap;">
                
              <div class="box" style="background-color:rgba(255, 255, 255, 0.5); height: 390px; width: 300px; padding: 10px 25px; border-radius: 5px; box-shadow: 3px 3px 3px rgb(2, 14, 53); margin: 20px 0px;">
                        <div class="imgFrame" style="height: 250px; width: 250px; overflow: hidden; display: flex; justify-content: center; margin: 5px 0px; box-shadow: 1px 1px 1px rgb(2, 14, 53);">
                            <img src="../images/s1.jpg" style="width: 120%; height:120%;">
                        </div> 
                        <div class="textFrame" style="height: 100px; width: 300px;">
                            <p class="prodName" style="margin:0px; font-weight: 600; font-size: 17px; ">台灣鐵路環島旅行帆布地圖</p>
                            <p class="company" style="margin:0px; font-weight: 100; ">By TRC台灣鐵道故事館 </p>
                            <p class="intro" style="margin:0px; font-weight: 400; font-size: 14px;">2018年最值得珍藏的一面臺灣地圖</p>
                           <p style="font-size: 20px; padding-left: 185px ;color: rgb(34, 9, 68)"> $500 <span style="font-size:27px; align-items: right;color:rgb(99, 97, 97)"><i class="fa fa-cart-plus fa-1x"  aria-hidden="true"></i></span></p>
                        </div>
                </div>
                
                
                
                <div class="box" style="background-color:rgba(255, 255, 255, 0.5); height: 390px; width: 300px; padding: 10px 25px; border-radius: 5px; box-shadow: 3px 3px 3px rgb(2, 14, 53); margin: 20px 0px;">
                        <div class="imgFrame" style="height: 250px; width: 250px; overflow: hidden; display: flex; justify-content: center; margin: 5px 0px; box-shadow: 1px 1px 1px rgb(2, 14, 53);">
                            <img src="../images/s2.gif" style="width: 120%; height:120%;">
                        </div> 
                        <div class="textFrame" style="height: 100px; width: 300px;">
                            <p class="prodName" style="margin:0px; font-weight: 600; font-size: 17px; ">老派的生活日曆</p>
                            <p class="company" style="margin:0px; font-weight: 100; ">By uDesign‧報時光 </p>
                            <p class="intro" style="margin:0px; font-weight: 400; font-size: 14px;">一份收藏時代心意、陪你用心生活的日曆/</p>
                           <p style="font-size: 20px; padding-left: 185px ;color: rgb(34, 9, 68)"> $399 <span style="font-size:27px; align-items: right;color:rgb(99, 97, 97)"><i class="fa fa-cart-plus fa-1x"  aria-hidden="true"></i></span></p>
                        </div>
                </div>
                
                <div class="box" style="background-color:rgba(255, 255, 255, 0.5); height: 390px; width: 300px; padding: 10px 25px; border-radius: 5px; box-shadow: 3px 3px 3px rgb(2, 14, 53); margin: 20px 0px;">
                        <div class="imgFrame" style="height: 250px; width: 250px; overflow: hidden; display: flex; justify-content: center; margin: 5px 0px; box-shadow: 1px 1px 1px rgb(2, 14, 53);">
                            <img src="../images/s7.jpg" style="width: 120%; height:120%;">
                        </div> 
                        <div class="textFrame" style="height: 100px; width: 300px;">
                            <p class="prodName" style="margin:0px; font-weight: 600; font-size: 17px; ">小綠郵精JUNIO</p>
                            <p class="company" style="margin:0px; font-weight: 100; ">By 雙手牌 </p>
                            <p class="intro" style="margin:0px; font-weight: 400; font-size: 14px;">來勉勵自己一起成長、一起變成更好的人！/</p>
                           <p style="font-size: 20px; padding-left: 185px ;color: rgb(34, 9, 68)"> $159 <span style="font-size:27px; align-items: right;color:rgb(99, 97, 97)"><i class="fa fa-cart-plus fa-1x"  aria-hidden="true"></i></span></p>
                        </div>
                </div>
                
                 <div class="box" style="background-color:rgba(255, 255, 255, 0.5); height: 390px; width: 300px; padding: 10px 25px; border-radius: 5px; box-shadow: 3px 3px 3px rgb(2, 14, 53); margin: 20px 0px;">
                        <div class="imgFrame" style="height: 250px; width: 250px; overflow: hidden; display: flex; justify-content: center; margin: 5px 0px; box-shadow: 1px 1px 1px rgb(2, 14, 53);">
                            <img src="../images/s4.jpg" style="width: 120%; height:120%;">
                        </div> 
                        <div class="textFrame" style="height: 100px; width: 300px;">
                            <p class="prodName" style="margin:0px; font-weight: 600; font-size: 17px; ">綠郵精</p>
                            <p class="company" style="margin:0px; font-weight: 100; ">By 雙手牌 </p>
                            <p class="intro" style="margin:0px; font-weight: 400; font-size: 14px;">這將會是你回憶中最棒的一封手寫信。/</p>
                           <p style="font-size: 20px; padding-left: 185px ;color: rgb(34, 9, 68)"> $349 <span style="font-size:27px; align-items: right;color:rgb(99, 97, 97)"><i class="fa fa-cart-plus fa-1x"  aria-hidden="true"></i></span></p>
                        </div>
                </div>
                
                 <div class="box" style="background-color:rgba(255, 255, 255, 0.5); height: 390px; width: 300px; padding: 10px 25px; border-radius: 5px; box-shadow: 3px 3px 3px rgb(2, 14, 53); margin: 20px 0px;">
                        <div class="imgFrame" style="height: 250px; width: 250px; overflow: hidden; display: flex; justify-content: center; margin: 5px 0px; box-shadow: 1px 1px 1px rgb(2, 14, 53);">
                            <img src="../images/s3.jpg" style="width: 120%; height:120%;">
                        </div> 
                        <div class="textFrame" style="height: 100px; width: 300px;">
                            <p class="prodName" style="margin:0px; font-weight: 600; font-size: 17px; ">Poly 幾何素體</p>
                            <p class="company" style="margin:0px; font-weight: 100; ">By AX2 </p>
                            <p class="intro" style="margin:0px; font-weight: 400; font-size: 14px;">最美的紓壓好夥伴/</p>
                           <p style="font-size: 20px; padding-left: 185px ;color: rgb(34, 9, 68)"> $289 <span style="font-size:27px; align-items: right;color:rgb(99, 97, 97)"><i class="fa fa-cart-plus fa-1x"  aria-hidden="true"></i></span></p>
                        </div>
                </div>
                
                  <div class="box" style="background-color:rgba(255, 255, 255, 0.5); height: 390px; width: 300px; padding: 10px 25px; border-radius: 5px; box-shadow: 3px 3px 3px rgb(2, 14, 53); margin: 20px 0px;">
                        <div class="imgFrame" style="height: 250px; width: 250px; overflow: hidden; display: flex; justify-content: center; margin: 5px 0px; box-shadow: 1px 1px 1px rgb(2, 14, 53);">
                            <img src="../images/s8.jpg" style="width: 120%; height:120%;">
                        </div> 
                        <div class="textFrame" style="height: 100px; width: 300px;">
                            <p class="prodName" style="margin:0px; font-weight: 600; font-size: 17px; ">組字印章</p>
                            <p class="company" style="margin:0px; font-weight: 100; ">By 來字哪裡</p>
                            <p class="intro" style="margin:0px; font-weight: 400; font-size: 14px;">六個組字印章，蓋出所有中文字！/</p>
                           <p style="font-size: 20px; padding-left: 185px ;color: rgb(34, 9, 68)"> $389 <span style="font-size:27px; align-items: right;color:rgb(99, 97, 97)"><i class="fa fa-cart-plus fa-1x"  aria-hidden="true"></i></span></p>
                        </div>
                </div>
                
                    <div class="box" style="background-color:rgba(255, 255, 255, 0.5); height: 390px; width: 300px; padding: 10px 25px; border-radius: 5px; box-shadow: 3px 3px 3px rgb(2, 14, 53); margin: 20px 0px;">
                        <div class="imgFrame" style="height: 250px; width: 250px; overflow: hidden; display: flex; justify-content: center; margin: 5px 0px; box-shadow: 1px 1px 1px rgb(2, 14, 53);">
                            <img src="../images/s9.jpg" style="width: 120%; height:120%;">
                        </div> 
                        <div class="textFrame" style="height: 100px; width: 300px;">
                            <p class="prodName" style="margin:0px; font-weight: 600; font-size: 17px; ">環島旅行</p>
                            <p class="company" style="margin:0px; font-weight: 100; ">By 故事館 </p>
                            <p class="intro" style="margin:0px; font-weight: 400; font-size: 14px;">2018年最值得珍藏。/</p>
                           <p style="font-size: 20px; padding-left: 185px ;color: rgb(34, 9, 68)"> $159 <span style="font-size:27px; align-items: right;color:rgb(99, 97, 97)"><i class="fa fa-cart-plus fa-1x"  aria-hidden="true"></i></span></p>
                        </div>
                </div>
                
                
                
                 <div class="box" style="background-color:rgba(255, 255, 255, 0.5); height: 390px; width: 300px; padding: 10px 25px; border-radius: 5px; box-shadow: 3px 3px 3px rgb(2, 14, 53); margin: 20px 0px;">
                        <div class="imgFrame" style="height: 250px; width: 250px; overflow: hidden; display: flex; justify-content: center; margin: 5px 0px; box-shadow: 1px 1px 1px rgb(2, 14, 53);">
                            <img src="../images/s10.jpg" style="width: 120%; height:120%;">
                        </div> 
                        <div class="textFrame" style="height: 100px; width: 300px;">
                            <p class="prodName" style="margin:0px; font-weight: 600; font-size: 17px; ">Poly</p>
                            <p class="company" style="margin:0px; font-weight: 100; ">By 杜廷倫 </p>
                            <p class="intro" style="margin:0px; font-weight: 400; font-size: 14px;">最值得珍藏/</p>
                           <p style="font-size: 20px; padding-left: 185px ;color: rgb(34, 9, 68)"> $359 <span style="font-size:27px; align-items: right;color:rgb(99, 97, 97)"><i class="fa fa-cart-plus fa-1x"  aria-hidden="true"></i></span></p>
                        </div>
                </div>
                
                
                
                
                
                
                
              
                
             
                <!-- 頁數 -->
                <div style="display: flex; width: 100%; justify-content: center; ">
                        <ul class="pagination">
                        <li class="page-item disabled">
                            <a class="page-link" href="#">&laquo;</a>
                        </li>
                        <li class="page-item active">
                            <a class="page-link" href="#">1</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">2</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">3</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">4</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">5</a>
                        </li>
                        <li class="page-item">
                            <a class="page-link" href="#">&raquo;</a>
                        </li>
                        </ul>
                </div>
            </div>
        </div>
        
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>          
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>