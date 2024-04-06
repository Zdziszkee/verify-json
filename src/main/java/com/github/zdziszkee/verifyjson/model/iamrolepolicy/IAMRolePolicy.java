package com.github.zdziszkee.verifyjson.model.iamrolepolicy;

import com.github.zdziszkee.verifyjson.model.iamrolepolicy.policydocument.statement.PolicyDocument;


/**
 * Contains information about an attached policy.
 * An attached policy is a managed policy that has been attached to a user, group, or role.
 * @param policyName
 * @param policyDocument
 */
public record IAMRolePolicy(String policyName, PolicyDocument policyDocument) {
}
