package org.example;

// A class with main application logic of the game.

public class Attack {

    Repository repository = new Repository();

    public void attackOnTargets() {
        boolean playersChoice = true;
        do {
            System.out.println("Choose id of a target:");
            repository.getListOfTargets();
            int playersChoiceTarget = GetInt.getInt();
            if (playersChoiceTarget > 0 && playersChoiceTarget < 6) {
                if (repository.getDamageOfTarget(playersChoiceTarget) < 100) {
                        boolean rocketChoice = true;
                        do {
                            System.out.println("Which rocket would you like to launch?");
                            repository.getListOfRockets();
                            int playersChoiceRocket = GetInt.getInt();
                            if (playersChoiceRocket > 0 && playersChoiceRocket <= 3) {
                                if (repository.getRangeOfRocket(playersChoiceRocket) < repository.getDistanceToTarget(playersChoiceTarget)) {
                                    System.out.println("The target is out of range of chosen rocket. Try again.\n");
                                }
                                if (repository.getRangeOfRocket(playersChoiceRocket) >= repository.getDistanceToTarget(playersChoiceTarget)) {
                                    System.out.println("The target is in range of the chosen rocket.");
                                    ProbabilityOfHit probabilityOfHit = new ProbabilityOfHit();
                                    if (probabilityOfHit.countProbabilityOfHit(repository.getDistanceToTarget(playersChoiceTarget), repository.getRangeOfRocket(playersChoiceRocket))) {
                                        repository.damageToTarget(playersChoiceTarget, repository.getDamageByRocket(playersChoiceRocket));
                                        System.out.println("The chosen rocket was launched and hit the target!\n" +
                                                "Current state of the target: ");
                                        repository.getOneTarget(playersChoiceTarget);
                                    } else {
                                        System.out.println("The rocket missed the target...");
                                        System.out.println();
                                    }
                                    rocketChoice = false;
                                }
                            } else {
                                System.out.println("Wrong number! Choose between 1 and 3.\n");
                            }
                        } while (rocketChoice);
                        playersChoice = false;
                } else {
                    repository.getOneTarget(playersChoiceTarget);
                    System.out.println("Is completely destroyed!\n");
                }
            } else {
                System.out.println("Wrong number! Choose between 1 and 5.\n");
            }
        } while (playersChoice);
    }
}