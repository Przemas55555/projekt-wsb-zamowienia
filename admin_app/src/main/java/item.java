/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 30Luty
 */
class item {
    private int id, price_netto, price_gross, amount;
    private String name;
    
    public item(int id, String name, int price_netto, int price_gross, int amount) {
        this.id = id;
        this.name = name;
        this.price_netto = price_netto;
        this.price_gross = price_gross;
        this.amount = amount;
    }
    
    public int getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }
    public int getPriceNetto()
    {
        return this.price_netto;
    }
    public int getPriceGross()
    {
        return this.price_gross;
    }
    public int getAmount()
    {
        return this.amount;
    }
}
