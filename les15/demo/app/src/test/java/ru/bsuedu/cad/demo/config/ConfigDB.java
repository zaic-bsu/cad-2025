import java.util.Properties;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "ru.bsuedu.cad.demo")
@EnableJpaRepositories(basePackages = "ru.bsuedu.cad.demo.repository")
@PropertySource("classpath:db/jdbc.properties")
@EnableTransactionManagement
public class ConfigDB {
    private static Logger LOGGER = LoggerFactory.getLogger(ConfigDB.class);

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.H2)
                    //.addScript("classpath:schema.sql")
                    //.addScript("classpath:data.sql")
                    .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());

        em.setPackagesToScan("ru.bsuedu.cad.demo.entity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        em.setJpaVendorAdapter(vendorAdapter);

        // Дополнительные свойства JPA/Hibernate
        Properties properties = new Properties();
        properties.put(Environment.HBM2DDL_AUTO, "create-drop");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        properties.put(Environment.FORMAT_SQL, true);
        properties.put(Environment.USE_SQL_COMMENTS, false);
        properties.put(Environment.SHOW_SQL, true);
        properties.put(Environment.MAX_FETCH_DEPTH, 3);
        properties.put(Environment.STATEMENT_BATCH_SIZE, 10);
        properties.put(Environment.STATEMENT_FETCH_SIZE, 50);
        em.setJpaProperties(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            @Autowired EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}


