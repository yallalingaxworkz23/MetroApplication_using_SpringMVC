<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile.jsp</title>
<link rel="icon" href="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    
</head>
<body>
<nav class="navbar sticky-top bg-body-tertiary">
             
             <div class="container-fluid">
                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="logo" style="height: 80px; width: 160px;">
                <h4>${username}</h4>
                 
                 <button onclick="onOpenModalForUploadImage(`${username}`)"  style="margin-left:700px "> <img alt="UpIm" style="height:70px;width: 60px; border-radius: 40%; margin-left:0px ;margin-top: 1px;padding: 0px"
           src="display?filename=${picPath == null ? 'temp.jpg' : picPath}">
<%--            filename=${picPath == null ? 'temp.jpg' : picPath} --%>
            </button>

         
                <a class="navbar-brand" href="login.jsp">SignIn</a>
                <button class="btn btn-primary"> <a href="editprofile?emailid=${username}" class="navbar-brand">edit-profile</a></button>
            </div>
</nav>

<h1>Well come to u r profile..</h1>
 <!--for image uplodae.. -->
    <!-- for block enable and disable -->
  <div id="id03" class="w3-modal" > 

 <!-- for block container -->
    <div class="w3-modal-content w3-card-4 w3-animate-zoom" style="max-width:300px;border-radius: 10px;border-bottom-left-radius:30px;">

<!-- for block animaction -->
      <div class="w3-center"><br>
        <span onclick="document.getElementById('id03').style.display='none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>
        <!-- <img src="img_avatar4.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top"> -->
      </div>

      <form class="w3-container" enctype="multipart/form-data" action="uploadUserImage" method="post">
        <div class="w3-section">

         <label><b>userName</b></label> 
          <input class="w3-input w3-border w3-margin-bottom bg-light" readonly="readonly" type="text" readonly="readonly"  name="emailid" id="emailid"  >
           	
         <label><b>uploadFile</b></label>
         <input type="file" name="file">
           
                
           
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Upload</button>
<!--           <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me -->
        </div>
                   
      </form>

      <div class="w3-container w3-border-top w3-padding-16 w3-light-grey">
        <button onclick="document.getElementById('id03').style.display='none'" type="button" class="w3-button w3-red" style="border-radius:10px;">Cancel</button>
<!--         <span class="w3-right w3-padding w3-hide-small">Forgot <a href="#">password?</a></span> -->
      </div>

    </div>
  </div>

<nav class="navbar fixed-bottom bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Fixed bottom</a>
  </div>
</nav>
</nav>

<script>

//for uplad the image 
function onOpenModalForUploadImage(emailid){
	 document.getElementById('emailid').value=emailid; 
	 document.getElementById("id03").style.display='block';  	 
}
</script>

</body>
</html>