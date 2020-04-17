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
    public int ramenNumber = 1; //这种面的数量

    private int extra_nori = 0;//多加多少紫菜，默认0，可以1-10或者1-99，99非常能吃
    private int extra_boiled_egg = 0;//多加多少鸡蛋
    private int Bamboo_shoots = 0;//多加多少竹笋
    private int extra_chashu= 0;//多加多少叉烧

    private float noriPrice = 1f;  //add-on的单价
    private float boiledEggPrice = 1f;
    private float bambooShootPrice = 1f;
    private float chashuPrice = 2f;

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

    public int getNum() { return this.ramenNumber; }

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

    public void setNum(int ramenNumber) {
        this.ramenNumber = ramenNumber;
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

    //add-on Amount
    public void setNoriPrice(float noriPrice) {
        this.noriPrice = noriPrice;
    }

    public void setChashuPrice(float chashuPrice) {
        this.chashuPrice = chashuPrice;
    }

    public void setBoiledEggPrice(float boiledEggPrice) {
        this.boiledEggPrice = boiledEggPrice;
    }

    public void setBambooShootPrice(float bambooShootPrice) {
        this.bambooShootPrice = bambooShootPrice;
    }

    public float getNoriAmount() {
        return this.noriPrice * this.extra_nori;
    }

    public float getBoiledEggAmount() {
        return this.boiledEggPrice * this.extra_boiled_egg;
    }

    public float getChashuAmount() {
        return this.chashuPrice * this.extra_chashu;
    }

    public float getBambooShootAmount() {
        return this.bambooShootPrice * this.Bamboo_shoots;
    }

    public float calcRamenAmount() {
        float RamenAmount = 9.9f;
        RamenAmount += this.getNoriAmount();
        RamenAmount += this.getBoiledEggAmount();
        RamenAmount += this.getBambooShootAmount();
        RamenAmount += this.getChashuAmount();
        return RamenAmount;
    }
}
