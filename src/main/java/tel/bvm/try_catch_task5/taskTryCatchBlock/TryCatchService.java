package tel.bvm.try_catch_task5.taskTryCatchBlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Напишите пример перехвата и обработки исключения в блоке try-catch метода.

/**
 * Класс {@code TryCatchService} демонстрирует использование блоков try-catch-finally
 * для обработки различных типов исключений, которые могут возникнуть при вводе
 * данных пользователем и выполнении арифметических операций.
 *
 * <p>В данном примере используется логирование для вывода информации о ходе выполнения программы
 * и обработки исключений с использованием библиотеки SLF4J и Logback.</p>
 */
public class TryCatchService {

   public static final Logger logger = LoggerFactory.getLogger(TryCatchService.class);

   /**
    * Основной метод программы. Считывает два числа с консоли, выполняет деление первого числа на второе
    * и выводит результат. В случае возникновения ошибок (например, неверный ввод, деление на ноль),
    * ошибки обрабатываются и логируются.
    *
    * @param args аргументы командной строки (не используются)
    */
   public static void main(String[] args) {

      BufferedReader reader = null;

      try {
         reader = new BufferedReader(new InputStreamReader(System.in));
         logger.info("Введите первое значение: ");
         String inputOne = reader.readLine();
         int numOne = Integer.parseInt(inputOne);

         logger.info("Введите второе значение: ");
         String inputTwo = reader.readLine();
         int numTwo = Integer.parseInt(inputTwo);

         int result = numOne / numTwo;

         logger.info("Результат деления: {}", result);

      } catch (IOException e) {
         logger.error("Ошибка ввода вывода: {}", e.getMessage());
      } catch (ArithmeticException e) {
         logger.error("Делитель не должен быть равен нулю: ", e);
      } catch (NumberFormatException e) {
         logger.error("Введено не допустимое значение переменной {}", e.getMessage());
      } catch (Exception e) {
          logger.error("Общее исключение, ошибка вида: {}", e.getMessage());
      } finally {
         try {
            if (reader != null) {
               reader.close();
               logger.info("Ресурс буфера обмена закрыт");
            }
         } catch (IOException e) {
            logger.error("Ошибка при закрытии ресурса обмена: {}", e.getMessage());
         }
         logger.info("Блок finally успешно выполнен");
      }
      logger.info("Расчёт полученных значений выполнен...");
   }
}