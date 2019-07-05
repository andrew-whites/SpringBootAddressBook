package com.example.addressBook.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.Expression;


/**
 * QEntryEntity is a Querydsl query type for EntryEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEntryEntity extends EntityPathBase<EntryEntity> {

    private static final long serialVersionUID = -1352675766L;

    public static ConstructorExpression<EntryEntity> create(Expression<String> firstName, Expression<String> lastName, Expression<String> addressLine1, Expression<String> addressLine2, Expression<String> addressLine3, Expression<String> city, Expression<String> county, Expression<String> country, Expression<String> postalCode, Expression<String> phoneNumber, Expression<String> emailAddress) {
        return Projections.constructor(EntryEntity.class, new Class<?>[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, firstName, lastName, addressLine1, addressLine2, addressLine3, city, county, country, postalCode, phoneNumber, emailAddress);
    }

    public static final QEntryEntity entryEntity = new QEntryEntity("entryEntity");

    public final StringPath addressLine1 = createString("addressLine1");

    public final StringPath addressLine2 = createString("addressLine2");

    public final StringPath addressLine3 = createString("addressLine3");

    public final StringPath city = createString("city");

    public final StringPath country = createString("country");

    public final StringPath county = createString("county");

    public final StringPath emailAddress = createString("emailAddress");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath lastName = createString("lastName");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath postalCode = createString("postalCode");

    public QEntryEntity(String variable) {
        super(EntryEntity.class, forVariable(variable));
    }

    public QEntryEntity(Path<? extends EntryEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEntryEntity(PathMetadata metadata) {
        super(EntryEntity.class, metadata);
    }

}

