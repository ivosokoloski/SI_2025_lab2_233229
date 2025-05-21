# SI_2025_lab2_233229

# Ivo Sokoloski 233229

## Control Flow Graph

![CFG_233229 drawio](https://github.com/user-attachments/assets/9d8d727b-88b6-430f-9121-04264224d08c)


## Цикломатска комплексност
Цикломатската комплексност е 6 и истата ја пресметав според независните региони во CFG-от пороге, има 5 независни региони а заедно со надворешнот 6.
## Тест случаи според критериумот Every statement
![EveryStatment](https://github.com/user-attachments/assets/4b1314b3-0151-4541-8c97-d845cc35713c)
public static double checkCart(List<Item> allItems, String cardNumber){
        if (allItems == null){  \\1
            throw new RuntimeException("allItems list can't be null!"); \\2
        }

        double sum = 0; \\3

        for (int i = 0; i < allItems.size(); i++){ \\4 \\5 \\14
            Item item = allItems.get(i); \\6
            if (item.getName() == null || item.getName().length() == 0){ \\7
                throw new RuntimeException("Invalid item!");  \\8
            }

            if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10){ \\9
                sum -= 30; \\10
            }

            if (item.getDiscount() > 0){  \\11
                sum += item.getPrice()*(1-item.getDiscount())*item.getQuantity();\\12
            }
            else {
                sum += item.getPrice()*item.getQuantity();  \\13
            }

        }
        if (cardNumber != null && cardNumber.length() == 16) {  \\15
            String allowed = "0123456789";  \\16
            char[] chars = cardNumber.toCharArray(); \\17
            for (int j = 0; j < cardNumber.length(); j++) { \\18  \19 \\23
                char c = cardNumber.charAt(j);  \\20
                if (allowed.indexOf(c) == -1) {  \\21
                    throw new RuntimeException("Invalid character in card number!"); \\22
                }
            }
        }
        else{
            throw new RuntimeException("Invalid card number!"); \\24
        }

        return sum; \\25
    }
}
Според моите пресметки потребни се минимум 6 тест случаи првиот тест случај е кога имаме null вредност за првиот if па се исполнува истиот па после имаме test case каде програмата продолжува понатаму до 7 гранка каде имаме повторно null вредност за да се исполни 8мата линија па потоа друг test case за да се исполни 10тата линија со вредности za getDiscount поголеми од нула но бидејќи со тоа нема да се исполни 13тата линија мора услов за тој if да е помал од 0 и за крај има два test cases  кои се разликуваат со тоа дали ќе се изврши exeption делот во 24тата линија соодветно или не.
