/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calc;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Widar
 */

//------------- OBS! Under konstrukition! ----------------
@Named
@RequestScoped
public class ArenanKalkylator {
    private int grad = 0, poang = 0, poangKvar = 0, totUng = 0, totVux = 0, totMed = 0,
                fysik = 0, health = 0, uth = 0, sb = 0,
                intel = 0, inl = 0, ls = 0, ska = 0,
                smi = 0, ini = 0, oe = 0, ua = 0, hugg = 0, katt = 0, kross = 0, skold = 0, stick = 0;
    
    List pointList = new ArrayList();
    
    ArenanKalkServer aKalk;
    
    String calcResult = "";
    
    public ArenanKalkylator () {
       System.out.println(calcResult);
    }

    public void calculate(){
        pointList.clear();
        pointList.add(health);
        pointList.add(uth);
        pointList.add(sb);
        pointList.add(inl);
        pointList.add(ls);
        pointList.add(ska);
        pointList.add(ini);
        pointList.add(oe);
        pointList.add(ua);
        pointList.add(hugg);
        pointList.add(katt);
        pointList.add(kross);
        pointList.add(skold);
        pointList.add(stick);
        aKalk = new ArenanKalkServer(pointList);
    }

    public String getCalcResult() {
        return calcResult;
    }

    public void setCalcResult(String calcResult) {
        this.calcResult = calcResult;
    }
    
    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public int getPoang() {
        poang = 150 + 20 * (grad - 1);
        return poang;
    }

    public void setPoang(int poang) {
        this.poang = poang;
    }

    public int getPoangKvar() {
        int i =  health + uth + sb + inl + ls + ska + ua + oe + ini + hugg + katt + kross + skold + stick;
        poangKvar = poang - i;
        return poangKvar;
    }

    public void setPoangKvar(int poangKvar) {
        this.poangKvar = poangKvar;
    }

    public int getTotUng() {
        return totUng;
    }

    public void setTotUng(int totUng) {
        this.totUng = totUng;
    }

    public int getTotVux() {
        return totVux;
    }

    public void setTotVux(int totVux) {
        this.totVux = totVux;
    }

    public int getTotMed() {
        return totMed;
    }

    public void setTotMed(int totMed) {
        this.totMed = totMed;
    }
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getFysik() {
        return fysik;
    }

    public void setFysik(int fysik) {
        this.fysik = fysik;
    }

    public int getUth() {
        return uth;
    }

    public void setUth(int uth) {
        this.uth = uth;
    }

    public int getSb() {
        return sb;
    }

    public void setSb(int sb) {
        this.sb = sb;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getInl() {
        return inl;
    }

    public void setInl(int inl) {
        this.inl = inl;
    }

    public int getLs() {
        return ls;
    }

    public void setLs(int ls) {
        this.ls = ls;
    }

    public int getSka() {
        return ska;
    }

    public void setSka(int ska) {
        this.ska = ska;
    }

    public int getSmi() {
        return smi;
    }

    public void setSmi(int smi) {
        this.smi = smi;
    }

    public int getUa() {
        return ua;
    }

    public void setUa(int ua) {
        this.ua = ua;
    }

    public int getOe() {
        return oe;
    }

    public void setOe(int oe) {
        this.oe = oe;
    }

    public int getIni() {
        return ini;
    }

    public void setIni(int ini) {
        this.ini = ini;
    }

    public int getHugg() {
        return hugg;
    }

    public void setHugg(int hugg) {
        this.hugg = hugg;
    }

    public int getKatt() {
        return katt;
    }

    public void setKatt(int katt) {
        this.katt = katt;
    }

    public int getKross() {
        return kross;
    }

    public void setKross(int kross) {
        this.kross = kross;
    }

    public int getSkold() {
        return skold;
    }

    public void setSkold(int skold) {
        this.skold = skold;
    }

    public int getStick() {
        return stick;
    }

    public void setStick(int stick) {
        this.stick = stick;
    }
    
}
