// Tipo di sostituzione
enum AlgosType {

    newOnly('NewOnly'),                                             // create only if doesn't exist
    always('Always'),                                               // always write the file
    firstTimeFalseAndAfterwardsOnlyNotModified('OnlyNotModified'),  // first time does nothing and then change only if not modified
    firstTimeTrueAndAfterwardsOnlyNotModified('OnlyFirstTime'),     // first time changes and then change only if not modified
    onlyAlreadyExisting('OnlyNotModified')                          // only if already existing

    public final String fileName


    AlgosType(String fileName) {
        this.fileName = fileName
    }
}
