# Program: Tax and Tip Calculator

print

# Tax calculator function
def taxCalc (cost, percentageTax):
    return (cost * (percentageTax / 100));

def tipCalc (cost, percentageTip):
    return (cost * (percentageTip / 100));

# Ask user if tip value should be calculated before or after tax [0 or 1]
print ("Should the tip be calculated before [0], or after tax [1]? \n");
tipSetting = int(input());

# Ask user for the cost
print ("Enter in the cost before tax and without a $ sign: \n");
cost = float(input());

# Ask user for tax percentage
print ("Enter in the TAX percentage as a whole number (i.e., 13% = 13) \n");
percentageTax = int(input());

# Ask user for tip percentage
print ("Enter in the TIP percentage as a whole number (i.e., 13% = 13) \n");
percentageTip = int(input());

# Return cost multiplied by tax percentage
costWithTax = taxCalc (cost, percentageTax);
print ("The cost with tax is: $" + str(costWithTax));

# If 0
if (tipSetting == 0):
    
	# Return cost multiplied by tip percentage for tip
    costOfTip = taxCalc (cost, percentageTip);
    print ("The cost of the tip calculated before tax is: $" + str(costOfTip));
    
# Else if 1
elif (tipSetting == 1):
    
	# Return cost + cost of tax multiplied by tip percentage for tip
    costOfTip = taxCalc (costWithTax, percentageTip);
    print ("The cost of the tip calculated after tax is: $" + str(costOfTip));