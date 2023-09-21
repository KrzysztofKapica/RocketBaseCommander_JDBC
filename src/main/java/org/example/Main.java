package org.example;

// Main manu of the game.

public class Main {
    public static void main(String[] args) {

        Attack attack = new Attack();
        Repository repository = new Repository();

        boolean wePlay = true;
        do {
            System.out.println("Choose action to do:");
            System.out.println("(1) List of targets");
            System.out.println("(2) List of rockets");
            System.out.println("(3) Choose a target to attack");
            System.out.println("(4) Exit");

            switch (GetInt.getInt()) {
                case (1) -> repository.getListOfTargets();
                case (2) -> repository.getListOfRockets();
                case (3) -> attack.attackOnTargets();
                case (4) -> wePlay = false;
            }
            System.out.println();
        }
        while (wePlay);
    }
}