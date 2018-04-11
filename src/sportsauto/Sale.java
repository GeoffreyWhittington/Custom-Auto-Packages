package sportsauto;

/**
 *
 * @author geoff_000
 */
public class Sale {
    //global private
    //<editor-fold>
    private boolean _cDChanger = false;
    private boolean _customWheels = false;
    private boolean _gPSNavigation = false;
    private boolean _rustfreePackage = false;
    private double _carSalesPrice;
    public String _inputCarSalesPrice;
    private double _tradeInAllowance;
    public String _inputtradeInAllowance;
    private final double CDChangerCost = 325.5;
    private final double CustomWheelsCost = 625.99;
    private final double GPSNavigationCost = 1200.;
    private final double RustFreePackageCost = 650.;
    //</editor-fold>
    public Sale()
    {
        System.out.println("SALES CLASS");
    }
    //getter/setters
    //<editor-fold>
    public boolean get_cDChanger()
    {
        
       return this._cDChanger;
    }
    
    public void set_cDChanger(boolean cDChanger)
    {
        this._cDChanger = cDChanger;
    }
    
    public boolean get_customWheels()
    {
        return this._customWheels;
    }
    
    public void set_customWheels(boolean customWheels)
    {
        this._customWheels = customWheels;
    }
    
    public boolean get_gPSNavigation()
    {
        return this._gPSNavigation;
    }
    
    public void set_gPSNavigaion(boolean gPSNavigation)
    {
        this._gPSNavigation = gPSNavigation;
    }
    
    public boolean get_rustfreePackage()
    {
        return this._rustfreePackage;
    }
    
    public void set_rustFreePackage(boolean rustFreePackage)
    {
        this._rustfreePackage = rustFreePackage;
    }
    
    public String get_carSalesPrice()
    {
        return this._inputCarSalesPrice;
    }
    
    public void set_carSalesPrice(String carSalesPrice)
    {
        this._inputCarSalesPrice = carSalesPrice;
    }
    
    public String get_tradeInAllowance()
    {
        return this._inputtradeInAllowance;
    }
    
    public void set_tradeInAllowance(String tradeInAllowance)
    {
        this._inputtradeInAllowance = tradeInAllowance;
    }
    
    //</editor-fold>
    //computations
    //<editor-fold>
    public double ComputeFeaturesCost()
    {
        double CatchersMitt = 0.0;
        if(this._cDChanger)
        {
            CatchersMitt += CDChangerCost;
        }  
            if(this._customWheels)
            {
                CatchersMitt += CustomWheelsCost;
            }
            
            if(this._gPSNavigation)
            {
                CatchersMitt += GPSNavigationCost;
            }
            
            if(this._rustfreePackage)
            {
                CatchersMitt += RustFreePackageCost;
            }
            
            return CatchersMitt;
    }
    
    public double ComputeSubtotal()
    {
        double CatchersMitt = this.ComputeFeaturesCost();
        
        CatchersMitt += this._carSalesPrice;
        CatchersMitt -= this._tradeInAllowance;
        return CatchersMitt;
    }
    
    private double ParseDouble(String amount)
    {
        double CatchersMitt = 0.0;
        
        try
        {
            CatchersMitt = Double.parseDouble(amount);
        }
        
        catch(Exception e)
        {
            
        }
        
        return CatchersMitt;
    }
    
    
    
    public double ComputeTax()
    { 
        double CatchersMitt = this.ComputeSubtotal();
        CatchersMitt *= .08;
        return CatchersMitt;
    }
    
    
    public double ComputeAmountDue()
    {  
        
        double CatchersMitt = this.ComputeSubtotal() + this.ComputeTax();
        return CatchersMitt;
    }
    
    public Exception HandleExceptions()
    {
        this._carSalesPrice = ParseDouble(this._inputCarSalesPrice);
        this._tradeInAllowance = ParseDouble(this._inputtradeInAllowance);
        Exception CatchersMitt = null;
        
        try
        {
            //Best Practice fFor Checking If Null
            if (_inputCarSalesPrice == null || _inputCarSalesPrice.isEmpty())
                
            {
                throw new Blank_Exception("ENTER CAR SALES PRICE ");
            }
            
             if (!this.tryParseDouble())
            
            {
                
                throw new NotNumeric_Exception("MUST BE A NUMBER ");
            }
             
            if(!HandleTradeinAllowance())
            {
                
                throw new NotNumeric_Exception("TRADE-IN ALLOWANCE MUST BE A NUMBER ");
            }
            
           if(_carSalesPrice <= 0)
            {
                throw new PriceZero_NegativeException("NO NEGATIVES/NO ZEROES ");
            }
             
           if (!this.tryParseDouble())
            
            {
                
                throw new NotNumeric_Exception("MUST BE A NUMBER ");
            }
            
           if(_tradeInAllowance < 0)
            {
                throw new PriceZero_NegativeException("TRADE-IN ALLOWANCE CAN'T BE LESS THAN ZERO ");
            }
            
           
        }
        
        
        catch(Blank_Exception ex)
        {
            //BLANK LOGIC
            CatchersMitt = ex;
            System.out.println(ex.getMessage());
        }
        
        catch(PriceZero_NegativeException ex)
        {
            //ZERO OR NEGATIVE LOGIC
            CatchersMitt = ex;
            System.out.println(ex.getMessage());
        }
        
        catch(NotNumeric_Exception ex)
        {
            //NONNUMERIC LOGIC
            CatchersMitt = ex;
            System.out.println(ex.getMessage());
        }
        
        finally
        {
            
        }
       return CatchersMitt;
    }
        public Boolean tryParseDouble()
        {
            Boolean valid = true;
            
            try
            {
                _carSalesPrice = Double.parseDouble(_inputCarSalesPrice);
                valid = true;
            }
            catch(Exception ex)
            {
                valid = false;
            }
            return valid;
            
        }
        
        public Boolean HandleTradeinAllowance()
        {
            Boolean valid = false;
           if(_inputtradeInAllowance == null || _inputtradeInAllowance.isEmpty())
           {
               _tradeInAllowance = 0.00;
               _inputtradeInAllowance = "0.00";
               valid = true;
           }
           
           else
           {
                try
            {
               _tradeInAllowance = Double.parseDouble(_inputtradeInAllowance);
               valid = true;
            }
            catch(Exception ex)
            {
                
                valid = false;
            }
                
           }
           
           
           
           
           
           return valid; 
        }
}
