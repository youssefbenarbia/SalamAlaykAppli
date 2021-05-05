<?php
include "fonctions.php";
// controle de réception de paramètres
if(isset($_REQUEST["operation"])) {
    // demande de récupération du dernier profil
    if($_REQUEST["operation"]=="dernier") {
        try{
            print("dernier%");
            $cnx = connexionPDO();
            $req = $cnx->prepare("select * from wpnn_users order by ID desc");
            $req->execute();
            //s'il y à un profil, récupération du premier
            if($ligne = $req->fetch(PDO::FETCH_ASSOC)) {
                print(json_encode($ligne));
            }
        }catch(PDOException $e) {
            print "erreur !%".$e->getMessage();
            die();
        }
    //enregistrement nouveau profil
    }elseif($_REQUEST["operation"]=="enreg") {
        try{
            //récupération des données en POST
            $lesdonnees = $_REQUEST["lesdonnees"];
            $donnee = json_decode($lesdonnees);
            $user_registered = $donnee[0];
            $user_login = $donnee[1];
            $user_nicename = $donnee[2];
            $user_email = $donnee[3];
            $user_pass = $donnee[4];
            //insertion dans la BDD
            print ("enreg%");
            $cnx = connexionPDO();
            $larequete = "insert into wpnn_users (user_login, user_pass, user_nicename, user_email, user_registered, user_status, display_name)";
            //$larequete .= "values ($user_login, $user_pass, $user_nicename, $user_email, \"$user_registered\", $user_status, $display_name)";
            $larequete .= "values (\"$user_login\", \"$user_pass\", \"$user_nicename\", \"$user_email\", NOW(), 0, \"$user_nicename\")";
            print($larequete);
            $req = $cnx->prepare($larequete);
            $req->execute();
        }catch(PDOException $e) {
            print "erreur !%". $e->getMessage();
            die();
        }
    //demande de récupération de tous les Logs (login/MDP) dus utilisateurs
    }elseif($_REQUEST["operation"]=="recupLogs") {
        try{
            $cnx = connexionPDO();
            $lesdonneesAcces = $_REQUEST["lesdonnees"];
            $donneeAcces = json_decode($lesdonneesAcces);
            $user_registered = $donneeAcces[0];
            $user_login = $donneeAcces[1];
            $user_nicename = $donneeAcces[2];
            $user_email = $donneeAcces[3];
            $user_pass = $donneeAcces[4];
            $req = $cnx->prepare("select * from wpnn_users where user_login = '$user_login' and user_pass = '$user_pass'");
            $req->execute();
            //s'il y à un profil, récupération de ce dernier
            if($ligne = $req->fetch(PDO::FETCH_ASSOC)) {
                print(json_encode($ligne));
            }
        }catch(PDOException $e) {
            print "erreur !%".$e->getMessage();
            die();
        }
    }
}