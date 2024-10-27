<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

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

    <!-- Trigger buttons for modals -->
    <button class="open-modal" data-modal="modal1">Open Modal 1</button>
    <button class="open-modal" data-modal="modal2">Open Modal 2</button>
    <button class="open-modal" data-modal="modal3">Open Modal 3</button>
    <button class="open-modal" data-modal="modal4">Open Modal 4</button>

    <!-- Modal 1 -->
    <div id="modal1" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2>Modal 1</h2>
            <p>This is the content of Modal 1.</p>
        </div>
    </div>

    <!-- Modal 2 -->
    <div id="modal2" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2>Modal 2</h2>
            <p>This is the content of Modal 2.</p>
        </div>
    </div>

    <!-- Modal 3 -->
    <div id="modal3" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2>Modal 3</h2>
            <p>This is the content of Modal 3.</p>
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
</body>
</html>