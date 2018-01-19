<div id="id01" class="modal">
    <!-- <span onclick="document.getElementById('id01').style.display='none'" class="close" title=se Modal">&times;</span> -->
    <div class="register">
        <h1>CREATE ACCOUNT</h1>
        <form class="modal-content animate" action="functions/register.php" method="POST">
            <div class="name">
                <div class="fname">
                    <h2>First Name</h2>
                    <input type="text" name="fname">
                </div>
                <div class="lname">
                    <h2 class="lastName">Last Name</h2>
                    <input type="text" name="lname">
                </div>
            </div>
            <h2>Email Address</h2>
            <input type="text" name="email">
            <h2>Password</h2>
            <input type="password" name="password">
            <!-- <h2>Confirm Password</h2>
            <input type="password" name="password"> -->
            <input type="submit" value="JOIN">
        </form>
    </div>
</div>
<script>
    // Get the modal
    var modal = document.getElementById('id01');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>