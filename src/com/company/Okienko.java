package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Okienko {


    private JPanel mojPanel;
    private JButton cztery;
    private JButton jeden;
    private JButton szesc;
    private JButton rownaSie;
    private JButton mnozenie;
    private JButton dzielenie;
    private JButton odejmowanie;
    private JButton dodawanie;
    private JButton przecinek;
    private JButton trzy;
    private JButton zero;
    private JButton dwa;
    private JButton piec;
    private JButton osiem;
    private JButton dziewiec;
    private JButton siedem;
    private JButton czysc;
    private JButton usunJedna;
    private JLabel ekran;
    private JLabel caleDzialanie;
    private JLabel notatka2;
    private JButton zmianaZnaku;
    private JLabel notatka;

    ArrayList<Double> tab_liczb = new ArrayList<Double>();
    ArrayList<Integer> tab_znakow = new ArrayList<Integer>();

    /*private double[] tab_liczb = new double[];
    private int[] tab_znakow = new int[];*/

    private String pokaz = new String();
    private String pokazCale = new String();
    private int dzialanie = 0;

    public Okienko() {
        notatka.setText("1. Czyszczenie następuje po kliknięciu znaku \"=\"");
        notatka2.setText("2. Kalkulator liczy \"od lewej do prawej\", brak kolejności wykonywania działań");
        jeden.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pokaz += "1";
                ekran.setText(pokaz);
            }
        });
        dwa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pokaz += "2";
                ekran.setText(pokaz);
            }
        });
        trzy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pokaz += "3";
                ekran.setText(pokaz);
            }
        });
        cztery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pokaz += "4";
                ekran.setText(pokaz);
            }
        });
        piec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pokaz += "5";
                ekran.setText(pokaz);
            }
        });
        szesc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pokaz += "6";
                ekran.setText(pokaz);
            }
        });
        siedem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pokaz += "7";
                ekran.setText(pokaz);
            }
        });
        osiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pokaz += "8";
                ekran.setText(pokaz);
            }
        });
        dziewiec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pokaz += "9";
                ekran.setText(pokaz);
            }
        });
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(pokaz.length()==1){
                    int check = 0;

                    if ((int) pokaz.charAt(0) == '0')
                        check = 1;

                    if(check == 0)
                        pokaz += "0";
                }
                else
                    pokaz += "0";

                ekran.setText(pokaz);
            }
        });
        przecinek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(pokaz.length()>0){
                    int check = 0;
                    for(int i=0; i<pokaz.length();i++) {
                        if ((int) pokaz.charAt(i) == '.')
                            check = 1;
                    }

                    if(check == 0)
                        pokaz += ".";
                }
                else
                    pokaz ="0.";
                ekran.setText(pokaz);
            }
        });




        dodawanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tab_liczb.add(Double.parseDouble(ekran.getText()));
                //System.out.println(tab_liczb.get(0));
                if(tab_liczb.get(tab_liczb.size()-1)<0)
                {
                    pokazCale +="[";
                    pokazCale += pokaz;
                    pokazCale +="]";
                }
                else
                    pokazCale += pokaz;

                pokazCale +=" + ";
                pokaz = "";
                ekran.setText(" ");
                caleDzialanie.setText(pokazCale);
                dzialanie = 1;
                tab_znakow.add(dzialanie);
            }
        });
        odejmowanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tab_liczb.add(Double.parseDouble(ekran.getText()));
                if(tab_liczb.get(tab_liczb.size()-1)<0)
                {
                    pokazCale +="[";
                    pokazCale += pokaz;
                    pokazCale +="]";
                }
                else
                    pokazCale += pokaz;

                dzialanie = 2;
                tab_znakow.add(dzialanie);
                //pokazCale += pokaz;
                pokazCale +=" - ";
                pokaz = "";
                ekran.setText(" ");
                caleDzialanie.setText(pokazCale);
            }
        });
        mnozenie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tab_liczb.add(Double.parseDouble(ekran.getText()));
                dzialanie = 3;
                tab_znakow.add(dzialanie);

                String pomocniczy = new String();
                pomocniczy +="(";
                for(int i=0; i<pokazCale.length();i++)
                {
                    pomocniczy += pokazCale.charAt(i);
                }

                pokazCale = pomocniczy;
                if(tab_liczb.get(tab_liczb.size()-1)<0)
                {
                    pokazCale +="[";
                    pokazCale += pokaz;
                    pokazCale +="]";
                }
                else
                    pokazCale += pokaz;

                pokazCale +=") * ";
                pokaz = "";
                ekran.setText(" ");
                caleDzialanie.setText(pokazCale);

            }
        });
        dzielenie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                double liczba = (Double.parseDouble(ekran.getText()));

                if (liczba == 0) {
                    ekran.setText("Nie dzielimy przez 0!");
                    pokaz = "";
                    pokazCale = "";
                    tab_liczb.clear();
                    tab_znakow.clear();
                }
                else {
                    tab_liczb.add(Double.parseDouble(ekran.getText()));
                    dzialanie = 4;
                    tab_znakow.add(dzialanie);

                    String pomocniczy = new String();
                    pomocniczy += "(";
                    for (int i = 0; i < pokazCale.length(); i++) {
                        pomocniczy += pokazCale.charAt(i);
                    }

                    pokazCale = pomocniczy;
                    if (tab_liczb.get(tab_liczb.size() - 1) < 0) {
                        pokazCale += "[";
                        pokazCale += pokaz;
                        pokazCale += "]";
                    } else
                        pokazCale += pokaz;

                    pokazCale += ") / ";
                    pokaz = "";
                    ekran.setText(" ");
                    caleDzialanie.setText(pokazCale);
                    }
                }


        });
        rownaSie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                double liczba = (Double.parseDouble(ekran.getText()));

                if(tab_znakow.get(tab_znakow.size()-1)==4)
                {
                    if(liczba == 0)
                    {
                        pokazCale = " ";
                        ekran.setText("Nie dzielimy przez 0!");
                    }
                    else
                    {
                        tab_liczb.add(liczba);
                        double wynik = 0;
                        wynik = licz(tab_liczb, tab_znakow);
                        pokazCale = " ";
                        caleDzialanie.setText(pokazCale);
                        ekran.setText(String.valueOf(wynik));
                    }
                }
                else
                {
                    tab_liczb.add(liczba);
                    double wynik = 0;
                    wynik = licz(tab_liczb, tab_znakow);
                    pokazCale = " ";
                    caleDzialanie.setText(pokazCale);
                    ekran.setText(String.valueOf(wynik));
                }
                pokaz = " ";
                pokazCale = " ";
                tab_liczb.clear();
                tab_znakow.clear();

            }
        });
        czysc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
            tab_liczb.clear();
            tab_znakow.clear();
            pokaz = " ";
            pokazCale = " ";
            ekran.setText(" ");
            caleDzialanie.setText(" ");
            }
        });
        usunJedna.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            String skrocony = new String();
            for(int i=0; i<pokaz.length()-1;i++)
            {
                skrocony += pokaz.charAt(i);
            }
            pokaz = skrocony;
            ekran.setText(pokaz);
            }
        });
        zmianaZnaku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pomocniczy = new String();
                if(pokaz.charAt(0) == '-' && pokaz.length()>0)
                {
                    for (int i = 1; i < pokaz.length(); i++) {
                        pomocniczy += pokaz.charAt(i);
                    }
                }
                else if(pokaz.charAt(0) != '-' && pokaz.length()>0) {
                    pomocniczy += "-";
                    for (int i = 0; i < pokaz.length(); i++) {
                        pomocniczy += pokaz.charAt(i);
                    }
                }
                pokaz = pomocniczy;
                ekran.setText(pokaz);
            }
        });
    }

    public JPanel getMojPanel() {
        return mojPanel;
    }


    double licz(ArrayList<Double> tab_liczb, ArrayList<Integer> tab_dzialan)
    {
        double wynik = 0;
        for(int i=0;i<tab_dzialan.size();i++)
        {
            int proba = tab_dzialan.get(i);
            System.out.println(proba);
            switch(tab_dzialan.get(i))
            {
                case 1:
                {
                    wynik = (tab_liczb.get(i) + tab_liczb.get(i+1));
                    tab_liczb.set(i+1, wynik);
                    break;
                }
                case 2:
                {
                    wynik = (tab_liczb.get(i) - tab_liczb.get(i+1));
                    tab_liczb.set(i+1, wynik);
                    break;
                }
                case 3:
                {
                    wynik = (tab_liczb.get(i) * tab_liczb.get(i+1));
                    tab_liczb.set(i+1, wynik);
                    break;
                }
                case 4:
                {
                    wynik = (tab_liczb.get(i) / tab_liczb.get(i+1));
                    tab_liczb.set(i+1, wynik);
                    break;
                }
            }
            wynik = tab_liczb.get(i+1);
            System.out.println(wynik);
        }
        return wynik;
    }


}
