package com.xtrader.nebulae.converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import lombok.extern.log4j.Log4j;

import com.xtrader.nebulae.converter.commands.ConverterCommand;

@Log4j
public class NebulaeConverterMain {
	
	public static void main(String[] args) {
		// command line parameter
		if (args.length != 1) {
			log.error("One argument is required");
			System.err.println("Invalid command line, exactly one argument required");
			System.exit(1);
		}
		
		try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
			String line = br.readLine();
	        while (line != null) {
	        	log.debug("reading line: "+ line);
	        	ConverterCommand cmd;
				try {
					cmd = CommandFactory.parseCommand(line);
					System.out.println(cmd.execute());
				} catch (Exception e) {
					log.debug("something gone wrong");
					System.err.println("Something gone wrong with your execution: " + e.getMessage());
					System.exit(1);
				}
	        	
	        	line = br.readLine();
	        }
	    } catch (IOException e) {
			e.printStackTrace();
			System.err.println("Problems reading your file");
			System.exit(1);
		}
	}
}
