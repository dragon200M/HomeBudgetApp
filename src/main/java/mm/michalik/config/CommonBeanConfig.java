package mm.michalik.config;

import mm.michalik.domain.ExpenseDetail;
import mm.michalik.domain.ExpenseDetailContainer;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by maciej on 01.09.16.
 */
@Configuration
public class CommonBeanConfig {



    @Bean
    public StrongPasswordEncryptor strongEncryptor(){
        StrongPasswordEncryptor encryptor=new StrongPasswordEncryptor();
        return encryptor;

    }

    @Bean
    public ExpenseDetailContainer detailContainer(){
        ExpenseDetailContainer exp=new ExpenseDetailContainer();
        exp.addToExpenseDetailsList(new ExpenseDetail());
        exp.addToExpenseDetailsList(new ExpenseDetail());
        exp.addToExpenseDetailsList(new ExpenseDetail());
        exp.addToExpenseDetailsList(new ExpenseDetail());
        exp.addToExpenseDetailsList(new ExpenseDetail());
        return exp;

    }


}
