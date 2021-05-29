import React from 'react';
import Modal from 'react-modal';

const ConfirmationModal = (props) => {
    console.dir(props.modalFlag)
    return (
        <Modal isOpen={props.modalFlag}>
        <button>Close Modal</button>
      </Modal>
    )
}

export default ConfirmationModal;