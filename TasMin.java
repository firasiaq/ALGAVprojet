

public class TasMin
{
    private int[] Tas; 
    private int taille;     // actuel nombre de éléments en Tasmin 											
    private int maxtaille; // maximum possible taille de Tasmin 
 
    private static final int root = 1;
    
 // Constructeur: Construit un tas à partir d'un tableau donné, 
    public TasMin(int maxtaille)
    {
        this.maxtaille = maxtaille;
        this.taille = 0;
        Tas = new int[this.maxtaille+1];
    
    }
 
    private int parent(int ps)
    {
        return ps / 2;
    }
 
    private int enfantgauche(int ps)
    {
        return (2 * ps);
    }
 
    private int  enfantdroite(int ps)
    {
        return (2 * ps) + 1;
    }
    private boolean estfeuille(int ps)
    {
        if (ps >=  (taille / 2)  &&  ps <= taille)
        {  
        
            return true;
           
        }
        return false;
    }
 
    private void swap(int pps, int eps)
    {
        int tmp;
        tmp = Tas[pps];
        Tas[pps] = Tas[eps];
        Tas[eps] = tmp;
    }
 
    private void tasminify(int ps)
    {
        if (!estfeuille(ps))
       { 
            if ( Tas[ps] > Tas[enfantgauche(ps)]  || Tas[ps] > Tas[enfantdroite(ps)])
            {
                if (Tas[enfantgauche(ps)] < Tas[enfantdroite(ps)])
                {
                    swap(ps, enfantgauche(ps));
                    tasminify(enfantgauche(ps));
                }else
                {
                    swap(ps, enfantdroite(ps));
                    tasminify(enfantdroite(ps));
                }
            }
        }
    }
 
    public void ajouts(int element)
    {
    	Tas[++taille] = element;
        int actuel = taille;
 
        while (Tas[actuel] < Tas[parent(actuel)])
         { 
            swap(actuel,parent(actuel));
            actuel = parent(actuel);
         }	
    }
 
    public void print()
    {
        for (int i = 1; i <= taille / 2; i++ )
        {
            System.out.print(" parent : " + Tas[i] + " enfant gauche : " + Tas[2*i] 
                + " enfant droite :" + Tas[2 * i  + 1]);
           System.out.println();
        } 
    }
 
    public void  ConsIter()
    {
        for (int ps = (taille / 2); ps >= 1 ; ps--)
        {
        	tasminify(ps);
        }
    }
 
    public int SupprMin()
    {
        int retire = Tas[root];
        Tas[root] = Tas[taille--]; 
        tasminify(root);
        return retire;
    }
    

 
    public static void main(String[]arg)
    {
        System.out.println("TasMin est");
        TasMin tasMin = new TasMin(9);
        tasMin.ajouts(4);
        tasMin.ajouts(3);
        tasMin.ajouts(18);
        tasMin.ajouts(11);
        tasMin.ajouts(33);
        tasMin.ajouts(19);
        tasMin.ajouts(6);
        tasMin.ajouts(22);
        tasMin.ajouts(9);
        tasMin.ConsIter();
        tasMin.print();
        System.out.println("le Min valeur " + tasMin.SupprMin());
        tasMin.print();
    }
}