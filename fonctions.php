<?php 
    function connexionPDO() {
        $login = "root";
        $password = "";
        $bdd = "salamaleykappbdd";
        $serveur = "localhost";
        try{
            $conn = new PDO("mysql:host=$serveur;dbname=$bdd", $login, $password);
            return $conn;
        }catch(PDOException $e) {
            print "erreur de connexion PDO";
            die();
        }
    }