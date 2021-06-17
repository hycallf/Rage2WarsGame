package pool;

import pool.domain.PoolModel;
import pool.domain.TierList;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PoolResult {

    private Integer total;
    private Integer rare;
    private Integer superRare;
    private Integer extremelyRare;
    private Integer godCard;
    private List<PoolModel> characters;


    public PoolResult(List<PoolModel> characters) {
        this.characters = characters;
        this.total = characters.size();
        this.rare = filterByTier(characters, TierList.B);
        this.superRare = filterByTier(characters, TierList.A);
        this.extremelyRare = filterByTier(characters, TierList.S);
        this.godCard = filterByTier(characters, TierList.SSS);
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
				"B: " + rare,
				"A: " + superRare,
				"S: " + extremelyRare,
                                "SSS: " + godCard);
    }

    public String getResultInPercentage() {
    	return String.format("%s%n%s%n%s%n",
				"B: " + getPercentage(rare, total) + "%",
				"A: " + getPercentage(superRare, total) + "%",
				"S: " + getPercentage(extremelyRare, total) + "%",
                                "SSS: " + getPercentage(godCard, total) + "%");
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

