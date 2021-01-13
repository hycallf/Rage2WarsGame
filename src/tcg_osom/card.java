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
    
    private String image, name, type, highlight;
    private int damage;

    public card(String image,String highlight, String name, String type, int damage) {
    this.image = image;
    this.highlight = highlight;
    this.name = name;
    this.type = type;
    this.damage = damage;
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

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getHighlight() {
        return this.highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }
}
