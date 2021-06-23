/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcg_osom;

/**
 *
 * @author FX8800
 */
import tcg_osom.PoolModel;
import tcg_osom.TierList;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PoolResult {

    private Integer total;
    private Integer normal;
    private Integer rare;
    private Integer superRare;
    private Integer extremelyRare;
    private List<PoolModel> characters;


    public PoolResult(List<PoolModel> characters) {
        this.characters = characters;
        this.total = characters.size();
        this.normal = filterByTier(characters, TierList.B);
        this.rare = filterByTier(characters, TierList.A);
        this.superRare = filterByTier(characters, TierList.S);
        this.extremelyRare = filterByTier(characters, TierList.SSS);
    }


    private Integer filterByTier(List<PoolModel> characters, TierList tierList) {
        return (int) characters.stream().filter(f -> f.getTier().equals(tierList.getTier())).count();
    }

    private double getPercentage(int partOf, int total) {
        double result = (double) partOf * 100.0 / (double) total;
        return BigDecimal.valueOf(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public void getTotal() {
        System.out.println("Your total of items are: " + total);
    }

    public String getResultInQuantity() {
    	return String.format("%s%n%s%n%s%n",
                                "Normal: " + normal,
				"Rare: " + rare,
				"Super Rare: " + superRare,
				"Extremely Rare: " + extremelyRare);
    }

    public String getResultInPercentage() {
    	return String.format("%s%n%s%n%s%n",
                                "Normal: " + getPercentage(normal,total) + "%",
				"Rare: " + getPercentage(rare, total) + "%",
				"Super Rare: " + getPercentage(superRare, total) + "%",
				"Extremely Rare: " + getPercentage(extremelyRare, total) + "%");
    }

    public Set<String> getResultListOfCharacters() {
        Set<String> results = new HashSet<>();
        for (PoolModel item : characters) {
            int quantity = (int) characters.stream().filter(f -> f.equals(item)).count();
            String result = quantity + "x " + item.getParsedTier() + item.getName();
            results.add(result);
        }
        return results;
    }
}