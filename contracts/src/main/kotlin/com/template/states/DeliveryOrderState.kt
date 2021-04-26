
package com.template.states

import com.template.contracts.DeliveryOrderContract
import net.corda.core.contracts.BelongsToContract
import net.corda.core.contracts.LinearState
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.Party


@BelongsToContract(DeliveryOrderContract::class)
data class DeliveryOrderState(
    val buyer: Party,
    val seller: Party,
    val deliveryCompany: Party,
    val products: Inventory,
    val accepted: Boolean = false, // tells us whether the products are with the delivery company
    
    override val participants: List<AbstractParty> = listOf(buyer, seller, deliveryCompany),
    override val linearId: UniqueIdentifier = UniqueIdentifier()
) : LinearState
