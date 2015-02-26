package com.faculdade.linguagem_programacao.trabalho;
class Smartphone
{
    private String os;
    private String screen;
    private String cpu;
    
    public String getOs()
    {
        return os;
    }
    
    public void setOs(String os)
    {
        this.os = os;
    }
    
    public String getScreen()
    {
        return screen;
    }
    
    public void setScreen(String screen)
    {
        this.screen = screen;
    }
    
    public String getCPU()
    {
        return cpu;
    }
    
    public void setCPU(String cpu)
    {
        this.cpu = cpu;
    }
    
    public String toString()
    {
        return "Operational System: " + os + "\nScreen: " + screen + "\nCPU: " + cpu;
    }
    
    public void print()
    {
        System.out.println(this);
    }
}

abstract class SmartphoneBuilder
{
    private Smartphone smartphone;
    
    public Smartphone getSmartphone()
    {
        return this.smartphone;
    }
    
    public void setSmartphone(Smartphone smartphone)
    {
        this.smartphone = smartphone;
    }
    
    public void createNewSmartphone()
    {
        smartphone = new Smartphone();
    }
    
    public abstract void buildOS();
    
    public abstract void buildScreen();
    
    public abstract void buildCPU();
}

class SamsungS4Builder extends SmartphoneBuilder
{
    public void buildOS()
    {
        getSmartphone().setOs("Android 4.2.2 Jelly Bean");
    }
    
    public void buildScreen()
    {
        getSmartphone().setScreen("Super AMOLED");
    }
    
    public void buildCPU()
    {
        getSmartphone().setCPU("SAMSUNG Exynos 5 Octa 5410");
    }
}

class IphoneBuilder extends SmartphoneBuilder
{
    public void buildOS()
    {
        getSmartphone().setOs("IOS 6");
    }
    
    public void buildScreen()
    {
        getSmartphone().setScreen("LED-backlit IPS TFT");
    }
    
    public void buildCPU()
    {
        getSmartphone().setCPU("Apple A6");
    }
}

class Factory
{
    private SmartphoneBuilder smartphoneBuilder;
    
    public void constructSmartphone()   
    {
    	smartphoneBuilder.createNewSmartphone();
    	smartphoneBuilder.buildOS();
    	smartphoneBuilder.buildScreen();
    	smartphoneBuilder.buildCPU();
    }
    
    public Smartphone getSmartphone()
    {
        return smartphoneBuilder.getSmartphone();
    }
    
    public void setSmartphoneBuilder(SmartphoneBuilder smartphoneBuilder)
    {
        this.smartphoneBuilder = smartphoneBuilder;
    }
}

public class TestBuilder
{
    public static void main (String [] args)
    {
        Factory factory = new Factory();
        
        SmartphoneBuilder iphoneBuilder = new IphoneBuilder();
        SmartphoneBuilder samsungS4Builder = new SamsungS4Builder();
        
        factory.setSmartphoneBuilder(iphoneBuilder);
        factory.constructSmartphone();
        factory.getSmartphone().print();
        
        factory.setSmartphoneBuilder(samsungS4Builder);
        factory.constructSmartphone();
        factory.getSmartphone().print();
    }
}