<div class="logo">
    <?php 
        session_start(); 
        if (!isset($_SESSION['userID'])) :
    ?>
    <div class="login">
        <a href="#" onclick="document.getElementById('id01').style.display='block'">JOIN / </a>
        <?php include "login/register.php"; ?>
        <a href="#" onclick="document.getElementById('id02').style.display='block'">SIGN IN</a>
        <?php include "login/login.php"; ?>
    </div>
    <?php else : 
        //Welcome message
    ?>
    <div class="login">
        <a href="viewOrder.php">Welcome <?php echo $_SESSION['firstName']; ?>!</a>
        <!-- Logout button -->
        <a href="core/login/logout.php"><img src="pics/icons/logout.png" alt="" style="width: 25px; float: right; margin-right: 20%; "></a>
    </div>
    <?php endif; ?>
    <a href="index.php"><img src="pics/logo.png" alt=""></a>
</div>

<nav class="top-nav">
    <ul class="top-nav-items">
        <li class="items">
            <a href="#"><div class="underline" style="color:white; font-weight: normal;">ABOUT US</div></a>
        </li>
        <li class="items">
            <div class="underline">WOMEN</div>
            <div class="dropdown-items">
                <div class="leftcolumn">
                    <a href="show.php?gender=women&brand=newin">NEW IN</a>
                    <a href="show.php?gender=women&brand=shoes">SHOES</a>
                    <a href="show.php?gender=women&brand=clogs">CLOGS</a>
                </div>
                <div class="rightcolumn">
                    <h3>FEATURES</h3>
                    <a href="show.php?gender=women&brand=hottest">HOTTEST</a>
                    <a href="show.php?gender=women&brand=collections">COLLECTIONS</a>
                </div>
            </div>
        </li>
        <li class="items">
            <div class="underline">MEN</div>
            <div class="dropdown-items">
                <div class="leftcolumn">
                    <a href="show.php?gender=men&brand=newin">NEW IN</a>
                    <a href="show.php?gender=men&brand=shoes">SHOES</a>
                    <a href="show.php?gender=men&brand=clogs">CLOGS</a>
                </div>
                <div class="rightcolumn">
                    <h3>FEATURES</h3>
                    <a href="show.php?gender=men&brand=hottest">HOTTEST</a>
                    <a href="show.php?gender=men&brand=collections">COLLECTIONS</a>
                </div>
            </div>
        </li>
        <li class="items">
            <div class="underline">KIDS</div>
            <div class="dropdown-items">
                <div class="leftcolumn">
                    <a href="show.php?gender=kids&brand=newin">NEW IN</a>
                    <a href="show.php?gender=kids&brand=shoes">SHOES</a>
                    <a href="show.php?gender=kids&brand=clogs">CLOGS</a>
                </div>
            </div>
        </li>
        <li class="items">
            <a href="search.php?search=shoes"><div class="underline" style="color:white; font-weight: normal;">SEARCH</div></a>
        </li>
    </ul>
</nav>