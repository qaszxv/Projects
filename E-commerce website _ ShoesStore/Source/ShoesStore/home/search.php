<?php
    require 'functions/config.inc.php'; 

    $search = $_GET['search']; 
?>

<div class="searchBar">
    <form method="GET">
        <input type="text" name="search" placeholder="<?php echo $search; ?>">
        <input type="submit" name="submit" value="SEARCH">
    </form>
</div>

<?php   
    $selectquery = "SELECT shoes.shoesID as shoesID, shoes.image1 as image1, shoes.shoesName as shoesName, shoes.description as description, shoes.gender as gender, shoes.brand as brand FROM shoes WHERE shoesName like CONCAT('%', '$search', '%') OR description like CONCAT('%', '$search', '%') OR gender like CONCAT('%', '$search', '%') OR brand like CONCAT('%', '$search', '%')"; 

    $result = mysqli_query($mysqli, $selectquery);

    while ($rows = mysqli_fetch_array($result)) {
        echo "<div class='item'>"; 
            echo "<a href='insidewomen.php?id=".$rows['shoesID']."'><img src='images/".$rows['image1']."'></a>"; 
            echo "<a href='insidewomen.php?id=".$rows['shoesID']."'><h1>".$rows['shoesName']."</h1></a>"; 
            echo "<div class='detail' style='height: 180px;'>"; 
                echo "<h3 style='padding: 10px 20px;'>".$rows['description']."</h3>"; 
            echo "</div>"; 
        echo "</div>"; 
    }
?>