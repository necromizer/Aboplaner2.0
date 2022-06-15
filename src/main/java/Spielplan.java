
// @author Valentin

public class Spielplan
{
    // Bekannte Daten
    int einsatztermine;
    String spielweise;
    int anzahlSpieler;
    int anzahlFeiertage;

    
    public Spielplan()
    {
        
    }
    
    public void algorithmus() throws InterruptedException
    {
        aufteilen(15, "Doppel", 7, 2);
        //aufteilen(9, "Einzel", 3, 4);
        //int einsatztermine, String spielweise, int anzahlSpieler, int anzahlFeiertage);
    }
    
    public void aufteilen(int einsatztermine, String spielweise, int anzahlSpieler, int anzahlFeiertage) throws InterruptedException
    {
        int spielerProSpiel;
	if (spielweise.equals("Doppel"))
	{
		spielerProSpiel = 4;
	}
	else
	{
		spielerProSpiel = 2;
	}
	
	int gesamtEinsätze = einsatztermine * spielerProSpiel;
	int einsätzeProSpieler = gesamtEinsätze / anzahlSpieler;
        
	int restEinsätze = gesamtEinsätze - einsätzeProSpieler * anzahlSpieler;
	
	int[] spielerArray = new int[anzahlSpieler];
	
	for (int i = 0; i < spielerArray.length; i++)
	{
		spielerArray[i] = einsätzeProSpieler;
		// Array wird aufgefüllt mit der Grundanzahl an Einsätzen
	}
	
	for (int i = 0; i < restEinsätze; i++)
	{
		spielerArray[i] += 1;
		// Gesamtanzahl der Spieleinsätze pro Spieler
	}

	int gesamtEinsätzeFeiertage = anzahlFeiertage * spielerProSpiel;
	int einsätzeFeiertageProSpieler = gesamtEinsätzeFeiertage / anzahlSpieler;
	
	int restEinsätzeFeiertage = gesamtEinsätzeFeiertage - einsätzeFeiertageProSpieler * anzahlSpieler;
        
	int[] spielerArrayFeiertage = new int[anzahlSpieler];
        
	for (int i = 0; i < spielerArrayFeiertage.length; i++)
	{
		spielerArrayFeiertage[i] = einsätzeFeiertageProSpieler;
		// Array wird aufgefüllt mit der Grundanzahl an Einsätzen an Feiertagen
	}

	for (int i = 0; i < restEinsätzeFeiertage; i++)
	{
		spielerArrayFeiertage[i] += 1;
		// Gesamtanzahl der Spieleinsätze pro Spieler an Feiertagen
	}
	
	int[] spielerArrayOhneFeiertage = new int[anzahlSpieler];
        
	for (int i = 0; i < anzahlSpieler; i++)
	{
		spielerArrayOhneFeiertage[i] = spielerArray[i] - spielerArrayFeiertage[i];
		// Tatsächliche Anzahl der Einsätze von jedem Spieler (Einsätze - Feiertage)
	}
        
        // Ausgabe der Werte
        for (int i = 0; i < anzahlSpieler; i++)
        {
            System.out.println("Gesamtanzahl der Spieleinsätze von Spieler " + (i+1) +": " + spielerArray[i]);
            System.out.println("Gesamtanzahl der Spieleinsätze von Spieler " + (i+1) +" an Feiertagen: " + spielerArrayFeiertage[i]);
            System.out.println("Gesamtanzahl der Spieleinsätze von Spieler " + (i+1) +" ohne Feiertage: " + spielerArrayOhneFeiertage[i]);
        }
        
        zuteilen(einsatztermine, spielerProSpiel, anzahlSpieler, spielerArray, spielerArrayFeiertage, spielerArrayOhneFeiertage);
    }
    
    public void zuteilen(int einsatztermine, int spielerProSpiel, int anzahlSpieler, int[] spielerArray, int[] spielerArrayFeiertage, int[] spielerArrayOhneFeiertage) throws InterruptedException
    {
        int hv = 0;
        int [] [] terminUebersicht = new int [einsatztermine] [spielerProSpiel];
        int [] spielerEinsaetze = new int [anzahlSpieler];
        int counter = 1;
        int kombinationszahl = 0;
        int zufall = 0;
        int abbruch = 0;
        int [] spielerArray2 = new int [anzahlSpieler];
        
        for (int a = 0; a < spielerArray.length; a++)
        {
            spielerArray2[a] = spielerArray[a];
        }
        
        System.out.println("");
        for (int i = 0; i < terminUebersicht.length; i++)
        {
            System.out.println("An Einsatztermin " + (i + 1) + " spielen folgende Spieler: ");
            for (int j = 0; j < terminUebersicht[i].length; j++)
            {
                if (spielerProSpiel == 2)
                {
                    if (anzahlSpieler == 3)
                    {
                        kombinationszahl = 1 + 2;
                        if (counter % kombinationszahl == 1)
                        {
                            if (j == 0)
                            {
                                terminUebersicht[i][j] = 1;
                                spielerArray2[0] -= 1;
                                spielerEinsaetze[0] += 1;
                            }
                            else
                            {
                                terminUebersicht[i][j] = 2;
                                spielerArray2[1] -= 1;
                                spielerEinsaetze[1] += 1;
                            }
                        }
                        else if (counter % kombinationszahl == 2)
                        {
                            if (j == 0)
                            {
                                terminUebersicht[i][j] = 3;
                                spielerArray2[2] -= 1;
                                spielerEinsaetze[2] += 1;
                            }
                            else
                            {
                                terminUebersicht[i][j] = 1;
                                spielerArray2[0] -= 1;
                                spielerEinsaetze[0] += 1;
                            }
                        }
                        else if (counter % kombinationszahl == 0)
                        {
                            if (j == 0)
                            {
                                terminUebersicht[i][j] = 2;
                                spielerArray2[1] -= 1;
                                spielerEinsaetze[1] += 1;
                            }
                            else
                            {
                                terminUebersicht[i][j] = 3;
                                spielerArray2[2] -= 1;
                                spielerEinsaetze[2] += 1;
                            }
                        }
                    }
                    else if (anzahlSpieler == 4)
                    {
                        kombinationszahl = 1 + 2 + 3;
                        if (counter % kombinationszahl == 1)
                        {
                            if (j == 0)
                            {
                                terminUebersicht[i][j] = 1;
                                spielerArray2[0] -= 1;
                                spielerEinsaetze[0] += 1;
                            }
                            else
                            {
                                terminUebersicht[i][j] = 2;
                                spielerArray2[1] -= 1;
                                spielerEinsaetze[1] += 1;
                            }
                        }
                        else if (counter % kombinationszahl == 2)
                        {
                            if (j == 0)
                            {
                                terminUebersicht[i][j] = 3;
                                spielerArray2[0] -= 1;
                                spielerEinsaetze[2] += 1;
                            }
                            else
                            {
                                terminUebersicht[i][j] = 4;
                                spielerArray2[1] -= 1;
                                spielerEinsaetze[3] += 1;
                            }
                        }
                        else if (counter % kombinationszahl == 3)
                        {
                            if (j == 0)
                            {
                                terminUebersicht[i][j] = 1;
                                spielerArray2[0] -= 1;
                                spielerEinsaetze[0] += 1;
                            }
                            else
                            {
                                terminUebersicht[i][j] = 3;
                                spielerArray2[1] -= 1;
                                spielerEinsaetze[2] += 1;
                            }
                        }
                        else if (counter % kombinationszahl == 4)
                        {
                            if (j == 0)
                            {
                                terminUebersicht[i][j] = 2;
                                spielerArray2[0] -= 1;
                                spielerEinsaetze[1] += 1;
                            }
                            else
                            {
                                terminUebersicht[i][j] = 4;
                                spielerArray2[1] -= 1;
                                spielerEinsaetze[3] += 1;
                            }
                        }
                        else if (counter % kombinationszahl == 5)
                        {
                            if (j == 0)
                            {
                                terminUebersicht[i][j] = 1;
                                spielerArray2[0] -= 1;
                                spielerEinsaetze[0] += 1;
                            }
                            else
                            {
                                terminUebersicht[i][j] = 4;
                                spielerArray2[1] -= 1;
                                spielerEinsaetze[3] += 1;
                            }
                        }
                        else if (counter % kombinationszahl == 0)
                        {
                            if (j == 0)
                            {
                                terminUebersicht[i][j] = 2;
                                spielerArray2[0] -= 1;
                                spielerEinsaetze[1] += 1;
                            }
                            else
                            {
                                terminUebersicht[i][j] = 3;
                                spielerArray2[1] -= 1;
                                spielerEinsaetze[2] += 1;
                            }
                        }
                    }
                    else if (anzahlSpieler >= 5)
                    {
                        if (j == 0)
                        {
                            zufall = (int)(Math.random() * anzahlSpieler)+1;
                            do
                            {
                                if (spielerArray2[zufall-1] == 0)
                                {
                                    zufall = (int)(Math.random() * anzahlSpieler)+1;
                                    hv = 0;
                                }
                                else
                                {
                                    spielerArray2[zufall-1] -= 1;
                                    terminUebersicht[i][j] = zufall;
                                    hv = 1;
                                }
                            }
                            while(hv != 1);
                            hv = 0;
                        }
                        else if (j == 1)
                        {
                            do
                            {
                                zufall = (int)(Math.random() * anzahlSpieler)+1;
                            }
                            while (zufall == terminUebersicht[i][0]);
                            do
                            {
                                if (spielerArray2[zufall-1] == 0)
                                {
                                    do
                                    {
                                        zufall = (int)(Math.random() * anzahlSpieler)+1;
                                    }
                                    while (zufall == terminUebersicht[i][0]);
                                    hv = 0;
                                }
                                else
                                {
                                    spielerArray2[zufall-1] -= 1;
                                    terminUebersicht[i][j] = zufall;
                                    hv = 1;
                                }
                            }
                            while (hv != 1);
                            hv = 0;
                        }
                        spielerEinsaetze[zufall-1] += 1;
                    }
                }
                else if (spielerProSpiel == 4)
                {
                    if (j == 0)
                    {
                        zufall = (int)(Math.random() * anzahlSpieler)+1;
                        do
                        {
                            if (spielerArray2[zufall-1] == 0)
                            {
                                zufall = (int)(Math.random() * anzahlSpieler)+1;
                                hv = 0;
//                                for (int neu = 0; neu < spielerArray2.length; neu++)
//                                {
//                                    if (spielerArray2[neu] == 0)
//                                    {
//                                        abbruch++;
//                                    }
//                                }
//                                if (abbruch == (spielerArray2.length-1))
//                                {
//                                    abbruch = 0;
//                                    for (int a = 0; a < terminUebersicht.length; a++)
//                                    {
//                                        for (int b = 0; b < terminUebersicht[a].length; b++)
//                                        {
//                                            terminUebersicht[a][b] = 0;
//                                        }
//                                    }
//                                    zuteilen(einsatztermine, spielerProSpiel, anzahlSpieler, spielerArray, spielerArrayFeiertage, spielerArrayOhneFeiertage);
//                                }
//                                else
//                                {
//                                    abbruch = 0;
//                                }
                            }
                            else
                            {
                                spielerArray2[zufall-1] -= 1;
                                terminUebersicht[i][j] = zufall;
                                hv = 1;
                            }
                        }
                        while(hv != 1);
                        hv = 0;
                    }
                    else if (j == 1)
                    {
                        do
                        {
                            zufall = (int)(Math.random() * anzahlSpieler)+1;
                        }
                        while (zufall == terminUebersicht[i][0]);
                        do
                        {
                            if (spielerArray2[zufall-1] == 0)
                            {
                                do
                                {
                                    zufall = (int)(Math.random() * anzahlSpieler)+1;
                                }
                                while (zufall == terminUebersicht[i][0]);
                                hv = 0;
                                // Verhinderung der endlosen Suche:
                                // Methodenneustart, wenn spielerArray2 stuckt
//                                for (int neu = 0; neu < spielerArray2.length; neu++)
//                                {
//                                    if (spielerArray2[neu] == 0)
//                                    {
//                                        abbruch++;
//                                    }
//                                }
//                                if (abbruch == (spielerArray2.length-1))
//                                {
//                                    abbruch = 0;
//                                    for (int a = 0; a < terminUebersicht.length; a++)
//                                    {
//                                        for (int b = 0; b < terminUebersicht[a].length; b++)
//                                        {
//                                            terminUebersicht[a][b] = 0;
//                                        }
//                                    }
//                                    zuteilen(einsatztermine, spielerProSpiel, anzahlSpieler, spielerArray, spielerArrayFeiertage, spielerArrayOhneFeiertage);
//                                }
//                                else
//                                {
//                                    abbruch = 0;
//                                }
                            }
                            else
                            {
                                spielerArray2[zufall-1] -= 1;
                                terminUebersicht[i][j] = zufall;
                                hv = 1;
                            }
                        }
                        while (hv != 1);
                        hv = 0;
                    }
                    else if (j == 2)
                    {
                        do
                        {
                            zufall = (int)(Math.random() * anzahlSpieler)+1;
                        }
                        while (zufall == terminUebersicht[i][0]
                                || zufall == terminUebersicht[i][1]);
                        do
                        {
                            if (spielerArray2[zufall-1] == 0)
                            {
                                do
                                {
                                    zufall = (int)(Math.random() * anzahlSpieler)+1;
                                }
                                while (zufall == terminUebersicht[i][0]
                                        || zufall == terminUebersicht[i][1]);
                                hv = 0;
                                // Verhinderung der endlosen Suche:
                                // Methodenneustart, wenn spielerArray2 stuckt
//                                for (int neu = 0; neu < spielerArray2.length; neu++)
//                                {
//                                    if (spielerArray2[neu] == 0)
//                                    {
//                                        abbruch++;
//                                    }
//                                }
//                                if (abbruch == (spielerArray2.length-1))
//                                {
//                                    abbruch = 0;
//                                    for (int a = 0; a < terminUebersicht.length; a++)
//                                    {
//                                        for (int b = 0; b < terminUebersicht[a].length; b++)
//                                        {
//                                            terminUebersicht[a][b] = 0;
//                                        }
//                                    }
//                                    zuteilen(einsatztermine, spielerProSpiel, anzahlSpieler, spielerArray, spielerArrayFeiertage, spielerArrayOhneFeiertage);
//                                }
//                                else
//                                {
//                                    abbruch = 0;
//                                }
                            }
                            else
                            {
                                spielerArray2[zufall-1] -= 1;
                                terminUebersicht[i][j] = zufall;
                                hv = 1;
                            }
                        }
                        while (hv != 1);
                        hv = 0;
                        
//                        do
//                        {
//                            terminUebersicht[i][j] = (int)(Math.random() * anzahlSpieler)+1;
//                        }
//                        while (terminUebersicht[i][2] == terminUebersicht[i][0]
//                                || terminUebersicht[i][2] == terminUebersicht[i][1]);
                    }
                    else if (j == 3)
                    {
                        do
                        {
                            zufall = (int)(Math.random() * anzahlSpieler)+1;
                        }
                        while (zufall == terminUebersicht[i][0]
                                || zufall == terminUebersicht[i][1]
                                || zufall == terminUebersicht[i][2]);
                        do
                        {
                            if (spielerArray2[zufall-1] == 0)
                            {
                                do
                                {
                                    zufall = (int)(Math.random() * anzahlSpieler)+1;
                                }
                                while (zufall == terminUebersicht[i][0]
                                        || zufall == terminUebersicht[i][1]
                                        || zufall == terminUebersicht[i][2]);
                                hv = 0;
                                // Verhinderung der endlosen Suche:
                                // Methodenneustart, wenn spielerArray2 stuckt
//                                for (int neu = 0; neu < spielerArray2.length; neu++)
//                                {
//                                    if (spielerArray2[neu] == 0)
//                                    {
//                                        abbruch++;
//                                    }
//                                }
//                                if (abbruch == (spielerArray2.length-1))
//                                {
//                                    abbruch = 0;
//                                    for (int a = 0; a < terminUebersicht.length; a++)
//                                    {
//                                        for (int b = 0; b < terminUebersicht[a].length; b++)
//                                        {
//                                            terminUebersicht[a][b] = 0;
//                                        }
//                                    }
//                                    zuteilen(einsatztermine, spielerProSpiel, anzahlSpieler, spielerArray, spielerArrayFeiertage, spielerArrayOhneFeiertage);
//                                }
//                                else
//                                {
//                                    abbruch = 0;
//                                }
                            }
                            else
                            {
                                spielerArray2[zufall-1] -= 1;
                                terminUebersicht[i][j] = zufall;
                                hv = 1;
                            }
                        }
                        while (hv != 1);
                        hv = 0;
                        
//                        do
//                        {
//                            terminUebersicht[i][j] = (int)(Math.random() * anzahlSpieler)+1;
//                        }
//                        while (terminUebersicht[i][3] == terminUebersicht[i][0]
//                                || terminUebersicht[i][3] == terminUebersicht[i][1]
//                                || terminUebersicht[i][3] == terminUebersicht[i][2]);
                        
                        //SortierAlgorithmus
                        
                        
                    }
                    spielerEinsaetze[zufall-1] += 1;
                }
                System.out.println("Spieler: " + terminUebersicht[i][j]);
            }
            counter++;
        }
        System.out.println("Die Einsatztermine: " + (counter-1));
        System.out.println();
        for (int x = 0; x < anzahlSpieler; x++)
        {
            System.out.println("Spieler " + (x+1) + ": " + spielerEinsaetze[x] + " Einsätze");
        }
        System.out.println();
        for (int y = 0; y < anzahlSpieler; y++)
        {
            System.out.println("Spieler " + (y+1) + " sollte Einsätze haben: " + spielerArray[y]);
        }
        
        // Alle möglichen Kombinationen berechnen und zuweisen
    }


}