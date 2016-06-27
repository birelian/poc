package net.birelian.poc.di.spring.model;

import java.util.Date;

/**
 * Base class for all entities.
 *
 * It is a good practice to extract common properties and features to a superclass so there is the minimum amount
 * of duplicated code.
 *
 * Class is abstract so it is not possible to instantiate it.
 */
public abstract class Item {

    protected Integer id;
    protected Date creationDate;
    protected Date modificationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }
}
