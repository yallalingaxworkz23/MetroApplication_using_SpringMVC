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
    <style>
    <style>
/* * { */
/*     margin: 0; */
/*     padding: 0; */
/*     box-sizing: border-box; */
/* } */

body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    height: 100vh;
}

h1 {
    margin-bottom: 20px;
}

button {
    padding: 10px 20px;
    margin: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    cursor: pointer;
    border-radius: 5px;
}

button:hover {
    background-color: #0056b3;
}

/* Modal styles */
.modal {
    display: none;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    justify-content: center;
    align-items: center;
}

.modal-content {
    background-color: white;
    padding: 20px;
    border-radius: 10px;
    max-width: 500px;
    width: 90%;
    text-align: center;
}

.close {
    position: absolute;
    top: 10px;
    right: 20px;
    font-size: 24px;
    cursor: pointer;
}

@media (max-width: 768px) {
    .modal-content {
        width: 80%;
        max-width: 350px;
    }

    button {
        width: 100%;
        max-width: 300px;
    }
}
    
    
    </style>
</head>
<body>
<nav class="navbar sticky-top bg-body-tertiary">
             
             <div class="container-fluid">
                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="logo" style="height: 80px; width: 160px;">
                    
                <h4>${username}</h4>
                <h4>${email}</h4>
                 
                 <button onclick="onOpenModalForUploadImage(`${email}`)"  style="margin-left:700px "> <img alt="UpIm" style="height:70px;width: 60px; border-radius: 40%; margin-left:0px ;margin-top: 1px;padding: 0px"
           src="display?filename=${picPath == null ? 'temp.jpg' : picPath}">
<%--            filename=${picPath == null ? 'temp.jpg' : picPath} --%>
            </button>

         
                <a class="navbar-brand" href="login.jsp">SignIn</a>
                <button class="btn btn-primary"> <a href="editprofile?emailid=${email}" class="navbar-brand">edit-profile</a></button>
            </div>
</nav><br>

<div style="margin-left: 10px">
                    <button class="open-modal" data-modal="modal1" style="padding: 8px;border-radius: 5px;background-color: blue">Add-Location</button> <span style="color: red">${forlocation}</span>
                    <button class="open-modal" data-modal="modal2"style="padding: 8px;border-radius: 5px;background-color: blue">Add-Price</button> <span style="color:red">${foraddprice}</span>
                    <button class="open-modal" data-modal="modal3" style="padding: 8px;border-radius: 5px;background-color: blue">Add-Train</button> <span style="color:red">${trainadd}</span>
                    <button class="open-modal" data-modal="modal4" style="padding: 8px;border-radius: 5px;background-color: blue">Open Modal 4</button></div>
                    
                     <!-- Modal 1 -->
    <div id="modal1" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2>Add-Location</h2>
            <form action="addLocation" method="post">
            <div class="mb-3">
               <label for="trainType" class="form-label" style="margin-right: 290px;">Train-Type</label>
               <input type="text" class="form-control"  name="trainType" id="traintype">
            </div>
              <div class="mb-3">
               <label for="AddLocation" class="form-label" style="margin-right: 290px;">Add-Location</label> 
               <input type="text" class="form-control"  name="addLocation" id="addLoaction">
            </div>
             <button type="submit" id="button"  class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>

    <!-- Modal 2 -->
    <div id="modal2" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2>Add-Price-List</h2>
           <form action="addPrice" method="post">
           <div class="mb-3">
               <label for="Source" class="form-label" style="margin-right: 290px;">Source</label>
               <input type="text" class="form-control"  name="source" id="source">
            </div>
            <p><b>To</b></p>
            <div class="mb-3">
               <label for="Destination" class="form-label" style="margin-right: 290px;">Destination</label>
               <input type="text" class="form-control"  name="destination" id="destination">
            </div>
            <div class="mb-3">
               <label for="trainType" class="form-label" style="margin-right: 290px;">Train-Type</label>
               <input type="text" class="form-control"  name="trainType" id="traintype">
            </div>
            <div class="mb-3">
               <label for="Price" class="form-label" style="margin-right: 290px;">Price</label>
               <input type="number" class="form-control"  name="price" id="price">
            </div>
             <button type="submit" id="button"  class="btn btn-primary">Submit</button>
           </form>
        </div>
    </div>

    <!-- Modal 3 -->
    <div id="modal3" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2>Add-Train</h2>
            <form action="addTrain" method="post">
             <div class="mb-3">
               <label for="TrainType" class="form-label" style="margin-right: 290px;">Train-Type</label>
               <input type="text" class="form-control"  name="trainType" id="trainType">
            </div>
             <div class="mb-3">
               <label for="TrainNum" class="form-label" style="margin-right: 290px;">Train-Num</label>
               <input type="text" class="form-control"  name="trainNum" id="trainNum">
            </div>
             <button type="submit" id="button"  class="btn btn-primary">Add</button>
            
            </form>
        </div>
    </div>
    <!-- Modal 4 -->
    <div id="modal4" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2>Modal 3</h2>
            <p>This is the content of Modal 3.</p>
        </div>
    </div>
    

<script>
//Get all modal trigger buttons
const modalTriggers = document.querySelectorAll('.open-modal');

// Get all modals
const modals = document.querySelectorAll('.modal');

// Add event listener for each modal trigger button
modalTriggers.forEach(trigger => {
    trigger.addEventListener('click', function() {
        const modalId = this.getAttribute('data-modal');
        document.getElementById(modalId).style.display = 'flex';
    });
});

// Add event listener to close the modals
modals.forEach(modal => {
    modal.addEventListener('click', function(e) {
        if (e.target.classList.contains('modal') || e.target.classList.contains('close')) {
            this.style.display = 'none';
        }
    });
});

</script>

<h1>Well come to u r profile..</h1>
 <!--for image uplodae.. -->
    <!-- for block enable and disable -->
  <div id="id03" class="w3-modal"  style="margin-top: 80px";> 

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