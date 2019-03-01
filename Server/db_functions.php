<?php 

class DB_Functions {
    private $conn;

    function __construct() {
        require_once "db_connect.php";
        $db = new DB_Connect();
        $this->conn = $db->connect();
    }

    function __destruct() {

    }

    function checkExistsUser($phone) {
        $stmt = $this->conn->prepare("SELECT * FROM user WHERE phone=?");
        $stmt->bind_param("s", $phone);
        $stmt->execute();
        $stmt->store_result();

        if ($stmt->num_rows > 0) {
            $stmt->close();
            return true;
        } else {
            $stmt->close();
            return false;
        }
    }

    public function registerNewUser($phone,$name,$birthidate,$address) {
        $stmt = $this->conn->prepare("INSERT INTO user(phone,name,birthdate,address) VALUES(?,?,?,?)");
        $stmt->bind_param("ssss", $phone,$name,$birthidate,$address);
        $result=$stmt->execute();
        $stmt->close();

        if ($result) {
            $stmt=$this->conn->prepare("SELECT * FROM user WHERE phone=?");
            $stmt->bind_param("s", $phone);
            $stmt->execute();
            $user=$stmt->get_result()->fetch_assoc();
            $stmt->close();
            return $user;
        } else {
            return false;
        }
    }

    public function getUserInformation($phone) {
        $stmt = $this->conn->prepare("SELECT * FROM user WHERE phone=?");
        $stmt->bind_param("s",$phone);

        if ($stmt->execute()) {
            $user = $stmt->get_result()->fetch_assoc();
            $stmt->close();

            return $user;
        } else {
            return null;
        }
    }

    public function getBanners() {
        $result = $this->conn->query("SELECT * FROM banner ORDER BY id LIMIT 3");

        $banners = array();

        while ($item = $result->fetch_assoc()) 
            $banners[] = $item;
        return $banners;        
    }

    public function getMenu() {
        $result = $this->conn->query("SELECT * FROM menu");

        $menu = array();

        while ($item = $result->fetch_assoc()) 
            $menu[] = $item;
        return $menu;        
    }

    public function getDrinkByMenuId($menuId) {

        $query = "SELECT * FROM drink WHERE menuId = '".$menuId."'";
        $result = $this->conn->query($query);

        $drinks = array();

        while ($item = $result->fetch_assoc()) 
            $drinks[] = $item;
        return $drinks;        
    }
}

?>