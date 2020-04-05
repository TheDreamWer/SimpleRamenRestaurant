package entities;

import java.io.Serializable;

/**
 * Entity class of ramen
 */
public class Ramen implements Serializable {
    /**
     * Attribute of ramen
     */
    private static final long serialVersionUID = 1L;
    private String soup = "Tonkosu";
    private String noodles="Soft";
    private int onion_level = 0;//0: No, 1: A little, 2: A lot
    private Boolean nori = false;
    private Boolean chashu = false;
    private Boolean boiled_egg = false;
    private int spiciness = 0;//0:no,1,2,3,4,5(max)

    private int extra_nori = 0;//多加多少紫菜，默认0，可以1-10或者1-99，99非常能吃
    private int extra_boiled_egg = 0;//多加多少鸡蛋
    private int Bamboo_shoots = 0;//多加多少竹笋
    private int extra_chashu= 0;//多加多少叉烧

    //Constructor
    // public Ramen() {

    // }

    //get methods
    public String getSoup() {
        return soup;
    }

    public String getNoodles() {
        return noodles;
    }

    public int getOnion_level() {
        return onion_level;
    }

    public Boolean getNori() {
        return nori;
    }

    public Boolean getChashu() {
        return chashu;
    }

    public Boolean getBoiled_egg() {
        return boiled_egg;
    }

    public int getSpiciness() {
        return spiciness;
    }

    //get methods for add-ons
    public int getExtra_nori() {
        return extra_nori;
    }

    public int getExtra_boiled_egg() {
        return extra_boiled_egg;
    }

    public int getExtra_chashu() {
        return extra_chashu;
    }

    public int getBamboo_shoots() {
        return Bamboo_shoots;
    }

   //set methods
    public void setSoup(String soup) {
        this.soup = soup;
    }

    public void setNoodles(String noodles) {
        this.noodles = noodles;
    }

    public void setOnion_level(int onion_level) {
        this.onion_level = onion_level;
    }

    public void setNori(Boolean nori) {
        this.nori = nori;
    }

    public void setChashu(Boolean chashu) {
        this.chashu = chashu;
    }

    public void setBoiled_egg(Boolean boiled_egg) {
        this.boiled_egg = boiled_egg;
    }

    public void setSpiciness(int spiciness) {
        this.spiciness = spiciness;
    }

    //add-ons
    public void setExtra_nori(int extra_nori) {
        this.extra_nori = extra_nori;
    }

    public void setExtra_boiled_egg(int extra_boiled_egg) {
        this.extra_boiled_egg = extra_boiled_egg;
    }

    public void setBamboo_shoots(int bamboo_shoots) {
        Bamboo_shoots = bamboo_shoots;
    }

    public void setExtra_chashu(int extra_chashu) {
        this.extra_chashu = extra_chashu;
    }
}
