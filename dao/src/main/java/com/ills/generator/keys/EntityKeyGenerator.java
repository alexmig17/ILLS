package com.ills.generator.keys;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.type.Type;


import java.io.Serializable;
import java.util.Properties;

import static org.hibernate.id.enhanced.SequenceStyleGenerator.*;

public class EntityKeyGenerator implements IdentifierGenerator, Configurable {

    public static final String SEQUENCE_PREFIX = "sequence_prefix";
    public static int i = 0;

    private String sequencePrefix;

    private String sequenceCallSyntax;

    @Override
    public void configure(Type type, Properties params, Dialect d) throws MappingException {


        sequencePrefix = ConfigurationHelper.getString(
                SEQUENCE_PREFIX,
                params,
                "SEQ_");

        final String sequencePerEntitySuffix = ConfigurationHelper.getString(
                SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX,
                params,
                SequenceStyleGenerator.DEF_SEQUENCE_SUFFIX);

        final String defaultSequenceName = ConfigurationHelper.getBoolean(
                SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY,
                params,
                false)
                ? params.getProperty(JPA_ENTITY_NAME) + sequencePerEntitySuffix
                : SequenceStyleGenerator.DEF_SEQUENCE_NAME;

    }

    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        return sequencePrefix + (i++);
    }

}
