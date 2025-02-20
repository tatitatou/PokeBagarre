package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.webapi.PokeBuildApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;



/*

1. Hortide VS Bulbizarre : Premier Pokémon gagne (meilleure attaque).
2. Bulbizarre VS Hortide : Second Pokémon gagne (meilleure attaque).
3. Hortide VS Empiflore : Second Pokémon gagne (meilleure défense et attaque plus forte).
4. Empiflore VS Hortide : Premier Pokémon gagne (meilleure défense et attaque plus faible).
5. Rapasdepic VS Dardargnan : Premier Pokémon gagne (même attaque, meilleure défense).
6. Dardargnan VS Rapasdepic : Second Pokémon gagne (même attaque, meilleure défense).
7. Rapasdepic VS Carmache : Premier Pokémon gagne (même attaque, même défense).

*/


class PokemonTests {

    // Un Pokémon plus puissant en combat un moins puissant
    // Le Pokémon plus puissant est vainqueur
    @Test // devraitEtreVainqueurSiPlusPuissant1
    void devraitEtreVainqueurSiPlusPuissant1() {
        Pokemon pokemonPlusPuissant = new Pokemon("PokemonPlusPuissant", "C:/Users/Jules/OneDrive/Pictures/saucisson.png", new Stats(149, 149));
        Pokemon pokemonMoinsPuissant = new Pokemon("PokemonMoinsPuissant", "C:/Users/Jules/OneDrive/Pictures/saucisson.png", new Stats(49, 49));

        boolean vainqueur = pokemonPlusPuissant.estVainqueurContre(pokemonMoinsPuissant);

        assertThat(vainqueur).isTrue();
    }

    // Un Pokémon moins puissant en combat un plus puissant
    // Le Pokémon plus puissant est vainqueur
    @Test // devraitEtreVainqueurSiPlusPuissant2
    void unPokemonMoinsPuissantEnCombatUnPlusPuissant2() {
        Pokemon pokemonPlusPuissant = new Pokemon("PokemonPlusPuissant", "C:/Users/Jules/OneDrive/Pictures/saucisson.png", new Stats(149, 149));
        Pokemon pokemonMoinsPuissant = new Pokemon("PokemonMoinsPuissant", "C:/Users/Jules/OneDrive/Pictures/saucisson.png", new Stats(49, 49));

        boolean vainqueur = pokemonMoinsPuissant.estVainqueurContre(pokemonPlusPuissant);

        assertThat(vainqueur).isFalse();
    }

    // Deux Pokémon avec la même attaque combattent, mais le premier a une plus grande défense
    // Le Pokémon avec la plus grande défense est vainqueur
    @Test // devraitEtreVainqueurSiPlusDeDefense1
    void devraitEtreVainqueurSiPlusDeDefense1() {
        Pokemon pokemonPlusGrandeDefense = new Pokemon("Pokemon1", "C:/Users/Jules/OneDrive/Pictures/saucisson.png", new Stats(149, 149));
        Pokemon pokemonPlusPetiteDefense = new Pokemon("Pokemon2", "C:/Users/Jules/OneDrive/Pictures/saucisson.png", new Stats(149, 49));

        boolean vainqueur = pokemonPlusGrandeDefense.estVainqueurContre(pokemonPlusPetiteDefense);

        assertThat(vainqueur).isTrue();
    }

    // Deux Pokémon avec la même attaque combattent, mais le second a une plus grande défense
    // Le Pokémon avec la plus grande défense est vainqueur
    @Test // devraitEtreVainqueurSiPlusDeDefense2
    void devraitEtreVainqueurSiPlusDeDefense2() {
        Pokemon pokemonPlusGrandeDefense = new Pokemon("Pokemon1", "C:/Users/Jules/OneDrive/Pictures/saucisson.png", new Stats(149, 149));
        Pokemon pokemonPlusPetiteDefense = new Pokemon("Pokemon2", "C:/Users/Jules/OneDrive/Pictures/saucisson.png", new Stats(149, 49));

        boolean vainqueur = pokemonPlusPetiteDefense.estVainqueurContre(pokemonPlusGrandeDefense);

        assertThat(vainqueur).isFalse();
    }

    // Deux Pokémon avec les mêmes attaque et défense combattent
    // Le Pokémon entré en premier est vainqueur
    @Test // devraitEtreVainqueurSiEnPremier
    void devraitEtreVainqueurSiEnPremier() {
        Pokemon pokemon1 = new Pokemon("Pokemon1", "C:/Users/Jules/OneDrive/Pictures/saucisson.png", new Stats(149, 149));
        Pokemon pokemon2 = new Pokemon("Pokemon2", "C:/Users/Jules/OneDrive/Pictures/saucisson.png", new Stats(149, 149));

        boolean vainqueur = pokemon1.estVainqueurContre(pokemon2);

        assertThat(vainqueur).isTrue();
    }
}