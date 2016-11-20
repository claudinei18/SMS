package com.cdh.sms.model;

/**
 * Created by cc on 16-11-18.
 */

public class Sanduiche {
    private String pao, carne;
    private String resto;

    private double caloria, valor;

    public Sanduiche(String pedido) {
        caloria = 0;
        valor = 0;
        processPedido(pedido);
        getCaloriaEValor(pedido);
    }

    private void getCaloriaEValor(String pedido) {
        String[] itens = pedido.split("\n");
        String tmp = "";
        for (String item: itens) {
            int i = 0;
            tmp = "";

            while (i < item.length() && !Character.isDigit(item.charAt(i))) { i++; }

            while (i < item.length() && Character.isDigit(item.charAt(i))) {
                tmp += item.charAt(i);
                i++;
            }

            caloria += Double.parseDouble(tmp);
            tmp = "";

            while (i < item.length() && !Character.isDigit(item.charAt(i))) { i++; }

            while (i < item.length() && Character.isDigit(item.charAt(i))) {
                tmp += item.charAt(i);
                i++;
            }

            valor += Double.parseDouble(tmp);
        }
    }

    private void processPedido(String pedido) {
        String[] itens = pedido.split("\n");
        pao = readUntilDigit(itens[0]);
        carne = readUntilDigit(itens[1]);

        if (itens.length > 2) {
            resto = "";
            for (int i=2; i<itens.length; i++) {
                resto += readUntilDigit(itens[i]);
            }
        } else {
            resto = null;
        }
    }

    private String readUntilDigit(String item) {
        String ret = "";
        int i = 0;
        while (i < item.length() && !Character.isDigit(item.charAt(i))) {
            ret += item.charAt(i);
            i++;
        }
        return ret;
    }

    public String getPao() {
        return pao;
    }

    public String getCarne() {
        return carne;
    }

    public String getResto() {
        return resto;
    }

    public double getCaloria() {
        return caloria;
    }

    public double getValor() {
        return valor;
    }
}
