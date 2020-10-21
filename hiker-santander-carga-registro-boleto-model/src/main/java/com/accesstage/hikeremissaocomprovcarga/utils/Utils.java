package com.accesstage.hikeremissaocomprovcarga.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.springframework.util.StringUtils;

import com.google.common.base.Strings;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utils {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
	static Calendar saoPauloDate = Calendar.getInstance(TimeZone.getTimeZone("America/Sao_Paulo"));	
	static SimpleDateFormat data = new SimpleDateFormat("YYYY-MM-dd");
	
    
    @SuppressWarnings("unused")
	public static String adicionarHoras(int hora) {
    	
        StringBuffer formattedDate = new StringBuffer();

        int ss = hora % 60;
        hora /= 60;
        int min = hora % 60;
        hora /= 60;
        int hh = hora % 24;
		
        saoPauloDate.add(Calendar.HOUR, hora);
		formattedDate.append(saoPauloDate.get(Calendar.HOUR_OF_DAY)).append(":");
		formattedDate.append(saoPauloDate.get(Calendar.MINUTE));

		return formattedDate.toString();
    	
    }
    
    public static Date getDataAtual(){
   	
    	saoPauloDate.setTime(new Date());
    	return saoPauloDate.getTime();
	}
    
    public static boolean comparaHora(String horaToken) {
    	
    	String horaAtual = sdf.format(saoPauloDate.getTime());
    	try {
            Date hora = sdf.parse(horaAtual); 
            Date token = sdf.parse(horaToken);
            
            if(hora.getTime() < token.getTime()){  
                return true;
            }  
            else{  
                return false;
            }
            
    	} catch (Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    
    
    public static String removeZeroEsquerda(String valor) {
		long x = Long.parseLong (valor);
		return  Long.toString(x);
    }
    
    public static String limitaCpfCnpj(String valor) {
		String x = valor.substring(1,15);
		return  x;
    }
    
    public static String formatarDataYYYYMMDD(String valor){    	
    	String dia = valor.substring(0,2);
    	String mes = valor.substring(2,4);
    	String ano = valor.substring(4,8);
    	return  ano + "-" + mes + "-" + dia;
    } 
    
    public static String formatarDataDDMMYYYY(String valor){
    	
    	if(!Strings.isNullOrEmpty(valor)) {
        	String ano = valor.substring(0,4);
        	String mes = valor.substring(4,6);
        	String dia = valor.substring(6,8);       	
        	return  dia + mes + ano  ;
    	}

    	return "";
    	
    }     
    
    public static Integer valueOf (String string) {
    	Integer x = null;
    	
    	try {
    		
        	if(!string.isEmpty() && string != null) {
        		x = Integer.parseInt(string);
        	}
    		
    	}catch (Exception e) {
    		return null;
    	} 
    	
    	return x;
    }
    
    public static String stringFormat(String valor, String posicoes) {
		valor = String.format("%-" + posicoes +"s", valor);
		return valor;
    	
    }
    
    public static String tratarNulo(String valor) {
    	if(valor == null) {
    		return "";
    	}
    	return valor;
    }
    
	/**
	 * Recebe a long no formato yyyyMMdd e faz o parse para data
	 *
	 * @param data
	 * @return o parse para data do formato acima
	 */
	@SuppressWarnings("finally")
	public static String converterToDateAsString(String data) {
		String dataFormatada = "";
		try {

			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyy");
			Date data2 = formato.parse(data);
			formato.applyPattern("yyyy-MM-dd");
			dataFormatada = formato.format(data2);

		} catch (ParseException e) {
			log.error(e.getMessage());
		} finally {
			return dataFormatada;
		}
	}
	
	public static Date converterToDateTime(String campo) {
		return converterToDate(campo, "HHmmss");
	}
	
	public static Date converterToDate(String campo) {
		return converterToDate(campo, "ddMMyyyy");
	}
	
	public static Date converterToDate(String campo, String formato) {
		Date date = null;
		try {
			SimpleDateFormat simpleFormatter = new SimpleDateFormat(formato);
			date = simpleFormatter.parse(campo);
		} catch (DateTimeParseException | ParseException dateTimeParseException) {
			log.error("ERRO NO PARSE DA DATA " + campo);
			log.error(dateTimeParseException.getMessage());
		}

		return date;
	}

	public static String recuperaValorBigDecimal(BigDecimal bigDecimal) throws Exception {

		DecimalFormat formatoDois = new DecimalFormat("##,###,###,##0.00",
				new DecimalFormatSymbols(new Locale("pt", "BR")));
		formatoDois.setMinimumFractionDigits(2);
		formatoDois.setParseBigDecimal(true);

		if (bigDecimal != null) {
			return formatoDois.format(bigDecimal.divide(new BigDecimal(100)));
		}
		return "";
	}

	public static Integer converterToInteger(final String campo) {
		Integer valorDefault = 0;

		try {
			if (!StringUtils.isEmpty(campo))
				valorDefault = Integer.valueOf(campo);
		} catch (NumberFormatException numberFormatException) {
			log.error("ERRO AO CONVERTER " + campo + "PARA INTEGER");
			log.error(numberFormatException.getMessage());
		}

		return valorDefault;
	}
	
	public static String converterToStringAsNumber(final String campo) {
		try {
			if (!StringUtils.isEmpty(campo))
				return Long.valueOf(campo).toString();
		} catch (NumberFormatException numberFormatException) {
			log.error("ERRO AO CONVERTER " + campo + "PARA INTEGER");
			log.error(numberFormatException.getMessage());
		}

		return null;
	}
	
	public static Long converterToLong(final String campo) {
		Long valorDefault = 0l;

		try {
			if (!StringUtils.isEmpty(campo))
				valorDefault = Long.valueOf(campo);
		} catch (NumberFormatException numberFormatException) {
			log.error("ERRO AO CONVERTER " + campo + "PARA LONG");
			log.error(numberFormatException.getMessage());
		}

		return valorDefault;
	}
	
	public static LocalDate converterToLocalDate(String campo) {
		LocalDate localDate = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

			localDate = LocalDate.parse(campo, formatter);
		} catch (DateTimeParseException dateTimeParseException) {
			log.error(dateTimeParseException.getMessage());
		}

		return localDate;
	}

	public static LocalTime converterToLocalTime(String hora) {
		LocalTime localTime = null;

		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
			localTime = LocalTime.parse(hora, formatter);
		} catch (DateTimeParseException dateTimeParseException) {
			log.error(dateTimeParseException.getMessage());
		}
		return localTime;
	}
	public static String removerCaracteresEspeciais(String string){
		if(!Strings.isNullOrEmpty(string)) {
			return string.replaceAll("[^a-zZ-Z0-9 ]", "");
		}
		return "";
	}

	public static boolean isNullOrBlank(String param) {
	    return param == null || param.trim().length() == 0;
	}    

}
