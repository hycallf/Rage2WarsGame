/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcg_osom;

/**
 *
 * @author KuroNeko
 */
public class card {
    
    private String image, name, type, highlight, selectImg, hand_card, rarity;
    private int id_card, attack, defence, damage;
    
    public card(String image, String highlight, String name, String type, int attack, int defence) {
        this.image = image;
        this.selectImg = selectImg;
        this.highlight = highlight;
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defence = defence;
    }
    
    public card(String image, String hand_card, String highlight, String name, String type, int attack, int defence, int id_card, String rarity, String selectImg){
        this.id_card = id_card;
        this.image = image;
        this.hand_card = hand_card;
        this.highlight = highlight;
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.selectImg = selectImg;
        this.attack = attack;
        this.defence = defence;
    }
    
    public card(){
        
    }

    public String getHand_card() {
        return hand_card;
    }

    public void setHand_card(String hand_card) {
        this.hand_card = hand_card;
    }
    
    
    public String getSelectImg() {
        return selectImg;
    }

    public void setSelectImg(String selectImg) {
        this.selectImg = selectImg;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHighlight() {
        return this.highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    
}
