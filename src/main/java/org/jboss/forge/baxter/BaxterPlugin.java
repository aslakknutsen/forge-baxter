/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.forge.baxter;

import java.util.Calendar;
import java.util.Date;

import org.jboss.forge.shell.ShellColor;
import org.jboss.forge.shell.plugins.Alias;
import org.jboss.forge.shell.plugins.Command;
import org.jboss.forge.shell.plugins.Help;
import org.jboss.forge.shell.plugins.PipeOut;
import org.jboss.forge.shell.plugins.Plugin;

/**
 * BaxterPlugin
 *
 * @author <a href="mailto:aslak@redhat.com">Aslak Knutsen</a>
 * @version $Revision: $
 */
@Alias("baxter")
@Help("Is it Baxter time?")
public class BaxterPlugin implements Plugin
{

   @Command(value = "time", help = "Check to see if it is Baxter time")
   public void isItTime(final PipeOut out)
   {
      out.println("Is it Baxter time? " + new Date());
      
      if(isOnBirthday())
      {
         printCongrats(out);
      }
      else
      {
         printTryAagain(out);
      }
   }

   /**
    * @return true if 9/6
    */
   private boolean isOnBirthday()
   {
      Calendar cal = Calendar.getInstance();
      if(cal.get(Calendar.DAY_OF_MONTH) == 9 && (cal.get(Calendar.MONTH) +1) == 6)
      {
         return true;
      }
      return false;
   }

   private void printCongrats(PipeOut out)
   {
      out.println(ShellColor.BOLD, "Hell yea!!");
      
      out.print("\n\n");
      
      for(int i = 0; i < 5; i++)
      {
         out.println(ShellColor.RED, "         ! ! ! HAPPY BIRTHDAY ! ! ! !");   
      }
      out.print("\n");
      
      String baxterLogo = 
      "   _                  _   _      ____   U  ___ u   _      _   _     \n" + 
      "  |\"|        ___     | \\ |\"|  U /\"___|   \\/\"_ \\/  |\"|    | \\ |\"|    \n" + 
      "U | | u     |_\"_|   <|  \\| |> \\| | u     | | | |U | | u <|  \\| |>   \n" + 
      " \\| |/__     | |    U| |\\  |u  | |/__.-,_| |_| | \\| |/__U| |\\  |u   \n" + 
      "  |_____|  U/| |\\u   |_| \\_|    \\____|\\_)-\\___/   |_____||_| \\_|    \n" + 
      "  //  \\\\.-,_|___|_,-.||   \\\\,-._// \\\\      \\\\     //  \\\\ ||   \\\\,-. \n" + 
      " (_\")(\"_)\\_)-' '-(_/ (_\")  (_/(__)(__)    (__)   (_\")(\"_)(_\")  (_/  \n" + 
      "\n" + 
      "   ____      _      __  __   _____ U _____ u   ____     \n" + 
      "U | __\")uU  /\"\\  u  \\ \\/\"/  |_ \" _|\\| ___\"|/U |  _\"\\ u  \n" + 
      " \\|  _ \\/ \\/ _ \\/   /\\  /\\    | |   |  _|\"   \\| |_) |/  \n" + 
      "  | |_) | / ___ \\  U /  \\ u  /| |\\  | |___    |  _ <    \n" + 
      "  |____/ /_/   \\_\\  /_/\\_\\  u |_|U  |_____|   |_| \\_\\   \n" + 
      " _|| \\\\_  \\\\    >>,-,>> \\\\_ _// \\\\_ <<   >>   //   \\\\_  \n" + 
      "(__) (__)(__)  (__)\\_)  (__)__) (__)__) (__) (__)  (__) \n" + 
      "\n" + 
      "                                               \n" + 
      "     ___          ___          ___             \n" + 
      "    |_\"_|        |_\"_|        |_\"_|            \n" + 
      "     | |          | |          | |             \n" + 
      "   U/| |\\u      U/| |\\u      U/| |\\u           \n" + 
      ".-,_|___|_,-..-,_|___|_,-..-,_|___|_,-.        \n" + 
      " \\_)-' '-(_/  \\_)-' '-(_/  \\_)-' '-(_/         \n";
   
      out.println(ShellColor.BOLD, baxterLogo);
      
      out.print("\n");
      for(int i = 0; i < 5; i++)
      {
         out.println(ShellColor.RED, "         ! ! ! HAPPY BIRTHDAY ! ! ! !");
      }
      out.print("\n");
   }

   private void printTryAagain(PipeOut out)
   {
      out.print("no it's not the right time.. try again later");      
   }
}
