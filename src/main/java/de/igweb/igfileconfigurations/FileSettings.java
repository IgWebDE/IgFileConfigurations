package de.igweb.igfileconfigurations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface FileSettings {

    /**
     * The path to the file
     **/
    public string Path;
    public string value;
    public string Passwort;
    String value();
    
    public string ReadFile(string Pass) 
    {
        if (Pass == Passwort) {
            /*Read&Co*/ 
        }
        
    }
    public void WriteFile(string Pass) 
    {
        if (Pass == Passwort) {
            /*Write&Co*/ 
        }
        
    }
    public void CreateNewFile(string path, string passwort)
    { if(Path == null && Passwort == null) {
    Path = path;
    Passwort = passwort; }
    }
    public void ChangePasswort (string OldPasswort, string NewPasswort) 
    {
     if(OldPasswort == Passwort) Passwort = NewPasswort;   
    }

}

