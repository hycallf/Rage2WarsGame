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
public enum TierList {
    SSS("SSS", 1.0, null),
    S("S", 10.0, SSS),
    A("A", 20.0, S),
    B("B", 69.0, A);

    private String tier;
    private Double percentage;
    private TierList next;

    public String getTier() {
        return this.tier;
    }

    public Double getPercentage() {
        return this.percentage;
    }

    TierList(String tier, Double percentage, TierList next) {
        this.tier = tier;
        this.percentage = percentage;
        this.next = next;
    }

    private Integer getPercentageNumber(Integer size) {
        double divisor = size;
        double result = this.getPercentage() / divisor * 100.0;
        return (int) result;
    }

    public Integer getPercentageNumberRecursively(Integer size) {
        TierList tier = this;
        double percentage = this.getPercentage();

        while (tier.next != null) {
            tier = tier.next;
            percentage += tier.getPercentageNumber(size);
        }

        return (int) percentage;
    }
    public static TierList fromBaseNumber(Integer baseNumber, Integer size) {
        for (TierList tierList : TierList.values()) {
            if (tierList.getPercentageNumberRecursively(size) >= baseNumber) {
                return tierList;
            }
        }
        throw new RuntimeException("Rarity Not Found in this Tier List " + baseNumber);
    }

}

