package  ma.zs.emailling.dao.specification.core.email;

import ma.zs.emailling.dao.criteria.core.email.EmailpieceJointCriteria;
import ma.zs.emailling.bean.core.email.EmailpieceJoint;
import ma.zs.emailling.zynerator.specification.AbstractSpecification;


public class EmailpieceJointSpecification extends  AbstractSpecification<EmailpieceJointCriteria, EmailpieceJoint>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("path", criteria.getPath(),criteria.getPathLike());
        addPredicate("taille", criteria.getTaille(),criteria.getTailleLike());
        addPredicateFk("email","id", criteria.getEmail()==null?null:criteria.getEmail().getId());
        addPredicateFk("email","id", criteria.getEmails());
        addPredicateFk("email","ref", criteria.getEmail()==null?null:criteria.getEmail().getRef());
        addPredicateFk("typeContenu","id", criteria.getTypeContenu()==null?null:criteria.getTypeContenu().getId());
        addPredicateFk("typeContenu","id", criteria.getTypeContenus());
        addPredicateFk("typeContenu","code", criteria.getTypeContenu()==null?null:criteria.getTypeContenu().getCode());
    }

    public EmailpieceJointSpecification(EmailpieceJointCriteria criteria) {
        super(criteria);
    }

    public EmailpieceJointSpecification(EmailpieceJointCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
